package com.example.mvi_rx_kotlin_androidversionsapi.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AndroidVersionsRequest {
    companion object AndroidVersionsRequestFactory {

        private const val BASE_URL = "https://api.learn2crack.com"

        fun androidVersionsRequest(): IAndroidVersionsService =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(IAndroidVersionsService::class.java)

    }
}