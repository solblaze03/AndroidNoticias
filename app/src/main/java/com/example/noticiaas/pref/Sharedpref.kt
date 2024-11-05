package com.example.noticiaas.pref

import android.content.Context

class Sharedpref(context:Context) {
    val nombd = "Mybd"
    val userkey= "user"
    val pass = "password"
    val ultimaNoticia = "Noticia"

    val datos = context.getSharedPreferences(nombd,0)

    fun guardarNombre(nom : String){
        datos.edit().putString(userkey,nom).apply()
    }
    fun obtenerUser() : String {
        return datos.getString(userkey,"") ?: ""
    }

    fun guardarContrasenya(password : String){
        datos.edit().putString(pass, password).apply()
    }
    fun obtenerPass() : String {
        return datos.getString(pass,"") ?: ""
    }
    fun guardarUltimaNoticia(noticia : String){
        return datos.edit().putString(ultimaNoticia,noticia).apply()
    }
    fun obtenerUltimaNoticia(): String {
        return datos.getString(ultimaNoticia,"") ?: ""
    }




}