package com.example.a0929desafio

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editCep = findViewById<EditText>(R.id.editCep)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val txtEndereco = findViewById<TextView>(R.id.txtEndereco)

        btnBuscar.setOnClickListener {

            val cep = editCep.text.toString()

            lifecycleScope.launch {

                try {

                    val endereco = ApiClient.service.buscarCep(cep)

                    txtEndereco.text = endereco.logradouro

                } catch (ex: Exception) {

                    txtEndereco.text = "Erro ao buscar endereço"
                }
            }
        }
    }
}