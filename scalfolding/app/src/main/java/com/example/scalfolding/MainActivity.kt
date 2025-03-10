package com.example.scalfolding

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scalfolding.ui.theme.ScalfoldingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScalfoldingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun prevista(){
    Aplicacion(modifier =Modifier.fillMaxSize())
}

@Composable
fun Aplicacion(modifier :Modifier){
    fun al_pulsar_el_carrito(){
        Log.v("Aplicacion","se ha pulsado el boton y se ha utilizado la funcion de el carrito")
    }
    Scaffold (modifier = Modifier,
        topBar = {
            Barra_superior()
        },
        bottomBar = {
            BarraInferior()
        },
        floatingActionButton = {
            Icon(Icons.Rounded.ShoppingCart, contentDescription = "")
        })
    { paddin_interior ->
        Column(modifier = Modifier.fillMaxSize().padding(paddin_interior).background(Color.Blue)) {
            Text("Este es un mensjae del otro mundo",
                modifier = Modifier
                .fillMaxSize(0.1f)
                .background(Color.Cyan)
            )
            Greeting("Esto es la columna", modifier = Modifier)
            Greeting("Esto es la columna", modifier = Modifier)
            Greeting("Esto es la columna", modifier = Modifier)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Barra_superior(){
    TopAppBar(title = {
        Text("titulo", modifier = Modifier)
    })
}

@Composable
fun BarraInferior(){
    fun boton_pulsado_inferior(){
        Log.v("Barra inferior","se ha pulsado el boton de abajo")
    }
    BottomAppBar{
        Row(verticalAlignment = Alignment.CenterVertically){
            Text("Aqui va una opcion")
            Spacer(modifier = Modifier.width(15.dp))
            Icon(Icons.Rounded.ShoppingCart, contentDescription = "Boton de carrito de compras")
            Boton_flotante(al_Pusho_picar = {})
        }

    }
}
@Composable
fun Boton_flotante(al_Pusho_picar: () -> Unit){
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Rounded.ShoppingCart, contentDescription = "")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier){
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
