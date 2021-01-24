package com.example.mvi_rx_kotlin_androidversionsapi.repo

import com.example.mvi_rx_kotlin_androidversionsapi.api.AndroidVersions
import com.example.mvi_rx_kotlin_androidversionsapi.api.AndroidVersionsRequest
import io.reactivex.rxjava3.core.Flowable

class AndroidVersionsRepo : IAndroidVersionsRepo {
    override fun getVersions(): Flowable<List<AndroidVersions>> =
        AndroidVersionsRequest.androidVersionsRequest().getAndroidVersions()
}