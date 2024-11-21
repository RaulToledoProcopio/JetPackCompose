package com.example.jetpackcompose.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompose.Navigation.AppScreen
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    val messages = listOf(
        R.string.nombre1,
        R.string.nombre2,
        R.string.nombre3,
        R.string.nombre4,
        R.string.nombre5,
        R.string.nombre6,
        R.string.nombre7
    )

    val profileImages = listOf(
        R.drawable.ic_profile1,
        R.drawable.ic_profile2,
        R.drawable.ic_profile3,
        R.drawable.ic_profile4,
        R.drawable.ic_profile5,
        R.drawable.ic_profile6,
        R.drawable.ic_profile7
    )

    val userNames = messages.map { id -> stringResource(id = id) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(R.color.whatsapp))
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp),
                contentDescription = "WhatsApp logo",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Text(
                text = "WhatsApp",
                color = Color.White,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_camera),
                contentDescription = "Camera Icon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(horizontal = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
                modifier = Modifier.size(25.dp)
            )
        }

        // Lista de chats
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.Fondo))
        ) {
            items(messages.size) { index ->
                MessageRow(
                    messageRes = messages[index],
                    imageRes = profileImages[index],
                    onClick = {
                        val userName = userNames[index]
                        navController.navigate("${AppScreen.Conversation.route}/$userName")
                    }
                )
            }
        }
    }
}

@Composable
fun MessageRow(messageRes: Int, imageRes: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = messageRes),
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    JetpackComposeTheme {
        val navController = rememberNavController()
        MainScreen(navController = navController, modifier = Modifier.fillMaxSize())
    }
}