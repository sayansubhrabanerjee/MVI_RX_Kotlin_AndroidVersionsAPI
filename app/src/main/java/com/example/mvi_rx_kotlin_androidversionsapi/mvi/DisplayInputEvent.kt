package com.example.mvi_rx_kotlin_androidversionsapi.mvi

sealed class DisplayInputEvent {
    object Show : DisplayInputEvent()
}