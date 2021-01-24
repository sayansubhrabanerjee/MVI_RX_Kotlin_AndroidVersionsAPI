package com.example.mvi_rx_kotlin_androidversionsapi.repo

import com.example.mvi_rx_kotlin_androidversionsapi.api.AndroidVersions
import io.reactivex.rxjava3.core.Flowable

interface IAndroidVersionsRepo {
    fun getVersions(): Flowable<List<AndroidVersions>>
}