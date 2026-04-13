package com.stiles.young.ui.theme.screens.authentication.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.stiles.young.R

@Composable
fun LoginScreen(){
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier.fillMaxSize(),
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

//    input for email
        OutlinedTextField(
            value = emailInput,
            onValueChange = { emailInput = it },
            maxLines = 1,
            label = {Text(text = "Enter Email")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email" ,
                    tint = Color.Black
                )
            },
            placeholder = { Text(text = "Email") }
        )

//    input for password
        OutlinedTextField(
            value = passwordInput,
            onValueChange = { passwordInput = it },
            maxLines = 1,
            label = { Text(text = "Enter Password") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password",
                    tint = Color.Black
                )
            },
            placeholder = { Text(text = "**********") },
        )
    }
}

@Composable
fun LottieAnimationWidget(drawable: Int, size: Dp = 350.dp) {
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

@Composable
fun UserInputWidget(){
      var textInput by remember{ mutableStateOf(TextFieldValue(""))}
      OutlinedTextField(
        value = textInput,
        onValueChange = {
            textInput = it
        },
    )
}
