package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
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
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Whatsapp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Whatsapp(modifier: Modifier = Modifier) {
    val messages = listOf(
        R.string.nombre1,
        R.string.nombre2,
        R.string.nombre3,
        R.string.nombre4,
        R.string.nombre5,
        R.string.nombre6,
        R.string.nombre7,
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
                    .background(color = colorResource(R.color.whatsapp))
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

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            items(messages.size) { index ->
                MessageRow(messageRes = messages[index], imageRes = profileImages[index])
            }
        }
    }
}

@Composable
fun MessageRow(messageRes: Int, imageRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen personalizada para cada usuario
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(50.dp)
                .padding(end = 16.dp)
        )

        Text(
            text = stringResource(id = messageRes),
            fontWeight = FontWeight.Normal
        )
    }
}
@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    JetpackComposeTheme {
        Whatsapp()
    }
}
