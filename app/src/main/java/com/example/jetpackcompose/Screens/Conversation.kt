package com.example.jetpackcompose.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun Conversation(navController: NavController, userName: String?) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Conversación con $userName")
        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Volver")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ConversationPreview() {
    JetpackComposeTheme {
        // Simulamos el NavController con rememberNavController
        val navController = rememberNavController()
        // Pasamos un userName fijo para la previsualización
        Conversation(navController = navController, userName = "Usuario Prueba")
    }
}