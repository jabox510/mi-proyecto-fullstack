package com.jabpark.miapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface VehiculoApi {
    @POST("vehiculos")
    fun registrarIngreso(@Body vehiculo: Vehiculo): Call<Vehiculo>
}
