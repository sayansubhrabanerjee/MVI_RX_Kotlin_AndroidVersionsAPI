package com.example.mvi_rx_kotlin_androidversionsapi.api

import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface IAndroidVersionsService {

    @GET("android/jsonarray/")
    fun getAndroidVersions(): Flowable<List<AndroidVersions>>
}