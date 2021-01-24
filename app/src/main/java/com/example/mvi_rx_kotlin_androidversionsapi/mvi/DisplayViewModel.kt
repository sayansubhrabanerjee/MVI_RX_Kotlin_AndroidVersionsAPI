package com.example.mvi_rx_kotlin_androidversionsapi.mvi

import com.example.mvi_rx_kotlin_androidversionsapi.api.AndroidVersions

sealed class DisplayViewModel {

    sealed class Displayer : DisplayViewModel() {
        data class Display(val androidVersions: List<AndroidVersions>) : Displayer()
    }
}
