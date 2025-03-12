package com.example.mvvm

import android.os.Bundle
import android.widget.NumberPicker.OnValueChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvm.modelos.modelo_cajon_texto
import com.example.mvvm.ui.theme.MvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MvvmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                        modelo_vista = modelo_cajon_texto()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, modelo_vista: modelo_cajon_texto) {
    val cajon_de_texto: String by modelo_vista.cajon_de_texto.observeAsState(initial = "Valor inicial de este lado")
    Column {
        Text(
            text = "Hello ${cajon_de_texto}!",
            modifier = modifier.fillMaxSize()
        )
        TextField(onValueChange = {}, value = cajon_de_texto)

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MvvmTheme { Greeting(Modifier.fillMaxSize(), modelo_vista = modelo_cajon_texto())
    }
}