package com.example.aplicacionparatomarfotos.pantallas

import android.content.Context
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import kotlin.coroutines.suspendCoroutine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import kotlin.coroutines.resume


@Composable
fun PantallaCamara(){
    val  lente_a_usar = CameraSelector.LENS_FACING_BACK
    val ciclo_de_vida_propietario = LocalLifecycleOwner.current
    val contexto = LocalContext.current
    val prevista = Preview.Builder().build()
    val vista_prevista = remember { PreviewView(contexto) }
    val camara_selector = CameraSelector.Builder().requireLensFacing(lente_a_usar).build()


    Box(contentAlignment = Alignment.BottomCenter){
        AndroidView(factory = {vista_prevista}, Modifier.fillMaxSize())

        Button(onClick = {}){
            Text("Holamundo")
        }
    }
    LaunchedEffect(lente_a_usar){
        val proveedor_local_camara = contexto.obtenerProveedorDeCamara()
        proveedor_local_camara.unbindAll()

        proveedor_local_camara.bindToLifecycle(ciclo_de_vida_propietario, camara_selector, prevista)
        prevista.setSurfaceProvider(vista_prevista.surfaceProvider)

    }

    AndroidView(factory = {vista_prevista}, Modifier.fillMaxSize())
}


private suspend fun Context.obtenerProveedorDeCamara(): ProcessCameraProvider =
    suspendCoroutine { continuacion ->
        ProcessCameraProvider.getInstance(this).also{proveedor_camara ->
            proveedor_camara.addListener({
                continuacion.resume(proveedor_camara.get())
            }, ContextCompat.getMainExecutor(this))
        }
    }