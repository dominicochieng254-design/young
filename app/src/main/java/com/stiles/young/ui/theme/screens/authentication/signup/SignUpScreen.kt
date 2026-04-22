package com.stiles.young.ui.theme.screens.authentication.signup

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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
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
fun SignUpScreen(navController: NavHostController = rememberNavController()) {
    var nameInput by remember { mutableStateOf(TextFieldValue("")) }
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPasswordInput by remember { mutableStateOf(TextFieldValue("")) }
    var isVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimationWidget(R.raw.king, 200.dp)
        
        Text(
            text = "CREATE ACCOUNT",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Name input
        OutlinedTextField(
            value = nameInput,
            onValueChange = { nameInput = it },
            label = { Text(text = "Full Name") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Name")
            },
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                focusedBorderColor = Color.Magenta
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

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

        Spacer(modifier = Modifier.height(10.dp))

        // Password input
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text(text = "Password") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_password_24),
                    contentDescription = "Password"
                )
            },
            trailingIcon = {
                IconButton(onClick = { isVisible = !isVisible }) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_visibility_off_24),
                        contentDescription = "Toggle Visibility"
                    )
                }
            },
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                focusedBorderColor = Color.Green
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Confirm Password
        OutlinedTextField(
            value = confirmPasswordInput,
            onValueChange = { confirmPasswordInput = it },
            label = { Text(text = "Confirm Password") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.outline_password_24),
                    contentDescription = "Confirm Password"
                )
            },
            shape = RoundedCornerShape(32.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedTextColor = Color.Blue,
                focusedBorderColor = Color.Cyan
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { 
                if (nameInput.text.isNotEmpty() && emailInput.text.isNotEmpty() && passwordInput.text.isNotEmpty()) {
                    if (passwordInput.text == confirmPasswordInput.text) {
                        Toast.makeText(context, "Account Created successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_LOGIN)
                    } else {
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            },
            shape = RoundedCornerShape(32.dp)
        ) {
            Text(text = "SIGN UP")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Already have an account? Login",
            modifier = Modifier.clickable { 
                navController.navigate(ROUTE_LOGIN)
            },
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
