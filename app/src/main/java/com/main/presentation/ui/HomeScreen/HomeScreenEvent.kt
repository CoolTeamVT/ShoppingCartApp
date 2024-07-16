package com.main.presentation.ui.HomeScreen

sealed class HomeScreenEvent {
    object BoxExtensionFirstEvent : HomeScreenEvent()
    object BoxExtensionSecondEvent : HomeScreenEvent()
    object BoxExtensionThirdEvent : HomeScreenEvent()
    object BoxExtensionFourthEvent : HomeScreenEvent()

}