package com.example.noticiaas.recycler

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.RoundedCorner
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.noticiaas.R
import com.example.noticiaas.pref.Noticias
import com.google.android.material.card.MaterialCardView

class viewHolder(val view: View) : ViewHolder(view) {

    val titulo = view.findViewById<TextView>(R.id.tituloNoticia)
    val resumen = view.findViewById<TextView>(R.id.descripcion)
    val imagen = view.findViewById<ImageView>(R.id.imagenNoticia)
    val fecha = view.findViewById<TextView>(R.id.fechaNoticia)
    val card = view.findViewById<MaterialCardView>(R.id.cardView)
    @RequiresApi(Build.VERSION_CODES.S)
    fun render(noticia: Noticias, cargarEnlace : (noticia : Noticias) -> Unit) {
        titulo.text = noticia.titulo
        resumen.text = noticia.Resumen
        fecha.text = noticia.Fecha
        Glide.with(view.context).load(noticia.imagen).centerCrop()
            .apply(RequestOptions.bitmapTransform(RoundedCorners(25))).into(imagen)

        card.setOnClickListener {
            cargarEnlace(noticia)
        }

    }

}