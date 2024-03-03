package com.example.artwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var currentIndex by remember { mutableStateOf(0) }
    val images = listOf(
        R.drawable.dice_1,
        R.drawable.dice_2,
        R.drawable.dice_3
    )
    val titles = listOf(
        "Art1",
        "Art2",
        "Art3"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(MaterialTheme.colorScheme.background)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = titles[currentIndex])
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentIndex = (currentIndex - 1 + images.size) % images.size
                }
            ) {
                Text("Назад")
            }
            Button(
                onClick = {
                    currentIndex = (currentIndex + 1) % images.size
                }
            ) {
                Text("Вперед")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
