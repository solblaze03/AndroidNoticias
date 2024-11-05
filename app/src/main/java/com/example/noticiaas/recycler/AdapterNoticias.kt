package com.example.noticiaas.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.noticiaas.R
import com.example.noticiaas.pref.Noticias

class AdapterNoticias(val noticias: List<Noticias>, val cargarEnlace : (noticias: Noticias) -> Unit) : RecyclerView.Adapter<viewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutinflater = LayoutInflater.from(parent.context)
        return viewHolder(layoutinflater.inflate(R.layout.noticia,parent,false))
    }

    override fun getItemCount(): Int {
        return noticias.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = noticias[position]
        return holder.render(item,cargarEnlace)

    }

}