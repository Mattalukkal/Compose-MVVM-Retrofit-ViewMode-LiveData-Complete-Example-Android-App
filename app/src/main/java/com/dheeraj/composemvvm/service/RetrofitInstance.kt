package com.dheeraj.composemvvm.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private const val BASE_URL = "https://random-data-api.com/api/v2/"
    private val client = OkHttpClient.Builder().addInterceptor(logging).build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val creditCardService: CreditCardService by lazy {
        retrofit.create(CreditCardService::class.java)
    }
}
