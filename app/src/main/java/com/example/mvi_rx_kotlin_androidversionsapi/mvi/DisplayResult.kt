package com.example.mvi_rx_kotlin_androidversionsapi.mvi

import com.example.mvi_rx_kotlin_androidversionsapi.api.AndroidVersions

sealed class DisplayResult {
    object Terminate : DisplayResult()

    sealed class Display : DisplayResult() {
        data class Show(val androidVersions: List<AndroidVersions>) : Display()
    }
}
