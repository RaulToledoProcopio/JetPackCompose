package com.example.jetpackcompose.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.R

@Composable
fun Conversation(navController: NavController, userName: String?) {
    val messages = listOf("Al final no voy, no me encuentro bien", "Es Lupus", "Eres tontísimo")
    val userMessage = remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.Fondo)) // Fondo de la conversación con el color que mencionaste
    ) {
        // Barra superior con el nombre de la conversación, foto y botón de volver
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.BurbujaUsuario))
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto del perfil a la izquierda
            Image(
                painter = painterResource(id = R.drawable.ic_profile1), // Asegúrate de poner el ícono correspondiente
                contentDescription = "Profile image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            // Título con el nombre del usuario
            Text(
                text = "Conversación con $userName",
                color = Color.White,
                modifier = Modifier.weight(1f) // Esto hace que el título ocupe el espacio restante
            )

            // Botón de volver a la pantalla principal, con texto clickable
            Text(
                text = "Volver",
                color = Color.White,
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        // Aquí van las burbujas de la conversación
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Mensajes de la conversación
            messages.forEachIndexed { index, message ->
                MessageBubble(
                    message = message,
                    isUser = index % 2 == 0 // Cambiar entre mensaje del usuario y del otro usuario
                )
            }

            Spacer(modifier = Modifier.weight(1f)) // Para que el campo de texto se quede abajo

            // Campo de texto para enviar mensajes
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                BasicTextField(
                    value = userMessage.value,
                    onValueChange = { userMessage.value = it },
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = CircleShape)
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun MessageBubble(message: String, isUser: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start
    ) {

        Text(
            text = message,
            color = Color.White,
            modifier = Modifier
                .background(if (isUser) colorResource(id = R.color.BurbujaUsuario) else Color.DarkGray, shape = RoundedCornerShape(16.dp))
                .padding(12.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ConversationPreview() {
    JetpackComposeTheme {
        val navController = rememberNavController()
        Conversation(navController = navController, userName = "Gregory House")
    }
}