package com.stiles.young

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stiles.young.ui.theme.YoungTheme
import com.stiles.young.ui.theme.screens.authentication.login.LoginScreen
import com.stiles.young.Greeting as Greeting1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YoungTheme{
                LoginScreen()
            }
        }
    }
}



@Composable
fun MyApp(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting1(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column{
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Hello World $name!",
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
YoungTheme {
        Greeting1("Android")
    }
}