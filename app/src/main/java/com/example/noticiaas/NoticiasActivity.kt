package com.example.noticiaas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noticiaas.databinding.ActivityNoticiasBinding
import com.example.noticiaas.pref.Loginuser
import com.example.noticiaas.pref.Noticias
import com.example.noticiaas.pref.Sharedpref
import com.example.noticiaas.pref.listaNoticias
import com.example.noticiaas.recycler.AdapterNoticias

class NoticiasActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNoticiasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticiasBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        cargarRecycler()
        val ultimaNoticia = Loginuser.prefs.obtenerUltimaNoticia()
        if(ultimaNoticia != "") { Toast.makeText(this,ultimaNoticia,Toast.LENGTH_SHORT).show()  }


    }

    fun cargarRecycler(){
        val displayMetrics = resources.displayMetrics
        val anchoPantalla = displayMetrics.widthPixels
        val itemAncho = 800
        val numeroColumnas = anchoPantalla / itemAncho
        val managerlayout = GridLayoutManager(this, numeroColumnas)

        binding.Recycler.layoutManager = managerlayout
        binding.Recycler.adapter = AdapterNoticias(listaNoticias.noticias) { e -> enviarEnlace(e)}

    }

    fun enviarEnlace(noticia : Noticias){
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(noticia.enlace)
        Loginuser.prefs.guardarUltimaNoticia(noticia.titulo)
        startActivity(intent)
    }
}