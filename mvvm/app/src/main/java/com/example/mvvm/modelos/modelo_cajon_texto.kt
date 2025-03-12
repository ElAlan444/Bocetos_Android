package com.example.mvvm.modelos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class modelo_cajon_texto: ViewModel() {
    private var _cajon_de_texto = MutableLiveData<String>("valor inicial")
    val cajon_de_texto: LiveData<String> = _cajon_de_texto

    fun pasar_nuevo_texto(texto_nuevo: String){
        Log.v("Entrada","El texto nuevo es ${texto_nuevo}!")

        _cajon_de_texto.value = texto_nuevo
    }
}