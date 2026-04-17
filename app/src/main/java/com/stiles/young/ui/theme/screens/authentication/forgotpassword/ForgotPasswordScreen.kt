package com.stiles.young.ui.theme.screens.authentication.forgotpassword

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.stiles.young.R
import com.stiles.young.navigation.ROUTE_LOGIN
import com.stiles.young.ui.theme.screens.authentication.login.LottieAnimationWidget

@Composable
fun ForgotPasswordScreen(navController: NavHostController = rememberNavController()) {
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimationWidget(R.raw.king, 250.dp)
        
        Text(
            text = "FORGOT PASSWORD",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))
        
        Text(
            text = "Enter your email to reset your password",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Email input
        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            label = { Text(text = "Email Address") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            },
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                focusedBorderColor = Color.Red
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { 
                if (emailInput.text.isNotEmpty()) {
                    Toast.makeText(context, "Reset link sent to ${emailInput.text}", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_LOGIN)
                } else {
                    Toast.makeText(context, "Please enter your email", Toast.LENGTH_SHORT).show()
                }
            },
            shape = RoundedCornerShape(32.dp)
        ) {
            Text(text = "RESET PASSWORD")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Back to Login",
            modifier = Modifier.clickable { 
                navController.navigate(ROUTE_LOGIN)
            },
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
