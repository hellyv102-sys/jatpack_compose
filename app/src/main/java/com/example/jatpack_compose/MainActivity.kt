package com.example.jatpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jatpack_compose.ui.theme.Jatpack_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jatpack_composeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ColorBoxApp(
                        modifier = Modifier.padding(innerPadding) )
                }
            }
        }
    }
}

@Composable
fun ColorBoxApp(modifier: Modifier = Modifier) {

    var redChecked by remember { mutableStateOf(false) }
    var greenChecked by remember { mutableStateOf(  false) }
    var blueChecked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Row {
            Checkbox(
                checked = redChecked,
                onCheckedChange = { redChecked = it }
            )
            Text("Red")
        }

        Row {
            Checkbox(
                checked = greenChecked,
                onCheckedChange = { greenChecked = it }
            )
            Text("Green")
        }

        Row {
            Checkbox(
                checked = blueChecked,
                onCheckedChange = { blueChecked = it }
            )
            Text("Blue")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top = 10.dp)
        ) {

            if (redChecked) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                )
            }

            if (greenChecked) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(18.dp)
                        .background(Color.Green)
                )
            }

            if (blueChecked) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(36.dp)
                        .background(Color.Blue)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColorBoxPreview() {
    Jatpack_composeTheme {
        ColorBoxApp()
    }
}