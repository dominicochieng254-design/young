package com.stiles.young.ui.theme.screens.authentication.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.stiles.young.R

@Composable
fun LoginScreen(
    navController: NavHostController = rememberNavController(),
    onNavigateToForgotPassword: () -> Unit
){
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }
    var isVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        AsyncImage(
            model = "https://images.unsplash.com/photo-1550745165-9bc0b252726f?q=80&w=2070&auto=format&fit=crop",
            contentDescription = "Login Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.3f
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
    //    lottie animation
            LottieAnimationWidget(R.raw.king, 250.dp)
            Text(
                text = "JOIN THE TECH",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black

            )

            Spacer(modifier = Modifier.height(20.dp))

    //    input for email
            OutlinedTextField(
                value = emailInput,
                onValueChange = { emailInput = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                maxLines = 1,
                label = {Text(text = "Enter Email")},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email" ,
                        tint = Color.Black
                    )
                },
                shape = RoundedCornerShape(size = 32.dp),
                placeholder = { Text(text = "Email") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color.Blue,
                    focusedBorderColor = Color.Red,
                    unfocusedContainerColor = Color.White.copy(alpha = 0.6f),
                    focusedContainerColor = Color.White.copy(alpha = 0.8f)
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

    //    input for password
            OutlinedTextField(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                maxLines = 1,
                visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
                label = {
                    Text(text = "Enter Password") },
                leadingIcon = {
                    Icon(
                      imageVector = ImageVector.vectorResource(id = R.drawable.outline_password_24),
                        contentDescription = "Password",
                        tint = Color.Black
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = { isVisible = !isVisible }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.outline_visibility_off_24),
                            contentDescription = "Toggle Visibility",
                            tint = Color.Black
                        )
                    }
                },
                shape = RoundedCornerShape(size = 32.dp),
                placeholder = {
                    Text(text = "**********")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedTextColor = Color.Blue,
                    focusedBorderColor = Color.Green,
                    unfocusedContainerColor = Color.White.copy(alpha = 0.6f),
                    focusedContainerColor = Color.White.copy(alpha = 0.8f)
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Handle Login */ },
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(text = "LOGIN", color = Color.White)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Forgot Password?",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(end = 32.dp, top = 8.dp)
                    .clickable { onNavigateToForgotPassword() },
                color = Color.DarkGray,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Don't have an account? Sign Up",
                modifier = Modifier.clickable { 
    //                navController.navigate(ROUTE_SIGNUP)
                },
                color = Color.Blue,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun LottieAnimationWidget(drawable: Int, size: Dp = 420.dp) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(drawable))

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(size)
    )
}
