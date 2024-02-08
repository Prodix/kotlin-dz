package com.example.carbrand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carbrand.ui.theme.CarBrandTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarBrandTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CarLogo()
                }
            }
        }
    }
}

@Composable
fun CarLogo(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var car by remember { mutableStateOf( 1) }
        val imageResource = when(car) {
            1 -> R.drawable.daewoo
            2 -> R.drawable.honda
            3 -> R.drawable.bmw
            4 -> R.drawable.ford
            5 -> R.drawable.mercedes
            6 -> R.drawable.haval
            7 -> R.drawable.hyundai
            8 -> R.drawable.lada
            9 -> R.drawable.tesla
            else -> R.drawable.opel
        }
        Image(modifier = Modifier.width(300.dp), painter = painterResource(id = imageResource), contentDescription = null)
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = { car = (1..10).random() }) {
            Text("Другая марка")
        }
    }
}
