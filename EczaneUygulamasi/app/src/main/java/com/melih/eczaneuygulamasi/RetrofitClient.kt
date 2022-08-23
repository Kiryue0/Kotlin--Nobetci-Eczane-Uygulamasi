package com.melih.eczaneuygulamasi

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.addHeaderLenient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {


    companion object{
        private val client = OkHttpClient.Builder().apply {
            addInterceptor(DistrictrInterceptor())
            addNetworkInterceptor(HttpLoggingInterceptor().apply {
               level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()



        fun getClient(baseUrl:String):Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}


