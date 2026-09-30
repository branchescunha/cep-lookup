package com.example.a0929desafio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    @GET ("{cep}/json")
    suspend fun buscarCep(@Path("cep") cep:String): Cep
}
object ApiClient{
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service: CepService = retrofit.create(CepService::class.java)
}