package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

        )

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(R.color.whatsapp))) {
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp),
                contentDescription = "Profile image",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 16.dp)
                    .clip(CircleShape)
                    .background(color = colorResource(R.color.whatsapp))
            )
            Text(
                text = "Whatsapp",
                modifier = Modifier
                    .padding(start = 0.dp) // Solo padding horizontal
                    .align(Alignment.CenterVertically),
                color = Color.White
            )

            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 10.dp)
                    .align(Alignment.CenterVertically)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp),
                contentDescription = "Whatsapp Icon",
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            items(messages.size) { index ->
                MessageRow(messageRes = messages[index])
            }
        }
    }
}


@Composable
fun MessageRow(messageRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Profile image",
            modifier = Modifier
                .size(40.dp)
                .padding(end = 16.dp)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(id = messageRes),
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        Whatsapp()
    }
}