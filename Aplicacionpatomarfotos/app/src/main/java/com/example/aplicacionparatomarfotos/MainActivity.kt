package com.example.aplicacionparatomarfotos

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.aplicacionparatomarfotos.pantallas.PantallaCamara
import com.example.aplicacionparatomarfotos.ui.theme.AplicacionParaTomarFotosTheme


class MainActivity : ComponentActivity() {
    private val evaluacion_permisos_camara =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { esta_garantizado->
            if(esta_garantizado){
                VistaDeLaCamara()

            }else{
                //Permiso denegado
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (PackageManager.PERMISSION_GRANTED){
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)->{
            //vista camara
            }
            else->{
                evaluacion_permisos_camara.launch(android.Manifest.permission.CAMERA)
            }
        }
        enableEdgeToEdge()
        setContent {
            AplicacionParaTomarFotosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
    private fun VistaDeLaCamara(){
        setContent {
            AplicacionParaTomarFotosTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PantallaCamara()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AplicacionParaTomarFotosTheme {
        Greeting("Android")
    }
}

