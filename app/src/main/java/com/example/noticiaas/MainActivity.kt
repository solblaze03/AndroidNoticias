package com.example.noticiaas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noticiaas.databinding.ActivityMainBinding
import com.example.noticiaas.pref.Loginuser.Companion.prefs


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var userform : String = ""
    private var passwordd : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userform = prefs.obtenerUser()
        passwordd = prefs.obtenerPass()
        Log.i("pref","$userform $passwordd")
        init()

    }

    fun mismaPasswordYUser(user: String, pass: String) : Boolean{

        if(userform.equals(user) && passwordd.equals(pass)){
            return true
        }
        return false
    }



    fun init(){
        if(prefs.obtenerUser() != "" && prefs.obtenerPass() != "") {
            binding.inputUser.setText(prefs.obtenerUser())
            binding.inputPass.setText(prefs.obtenerPass())
        }
        binding.iniciar.setOnClickListener{
            cargar()
        }
    }
    fun cargar(){


        val soloIniciar = mismaPasswordYUser(binding.inputUser.text.toString(), binding.inputPass.text.toString())



        if (binding.inputUser.text.toString().length >= 6 && binding.inputPass.text.toString().length >= 6 && !soloIniciar) {
            Log.i("Entra", "${soloIniciar}")
            prefs.guardarNombre(binding.inputUser.text.toString())
            prefs.guardarContrasenya(binding.inputPass.text.toString())
            prefs.guardarUltimaNoticia("")
            userform = prefs.obtenerUser()
            passwordd = prefs.obtenerPass()
            Toast.makeText(this,"Datos ${binding.inputUser.text.toString()} guardados",Toast.LENGTH_SHORT).show()

            val intent = Intent(this,NoticiasActivity::class.java)
            startActivity(intent)

        }else{
            if(binding.inputUser.text.toString().length < 6  || binding.inputPass.text.toString().length < 6){
                Toast.makeText(this,"Minimo 6 caracteres en ambos campos",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,NoticiasActivity::class.java)
                startActivity(intent)
            }
        }

    }


}