package com.yourcompany.android.jetpackcompose.router

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
   object Navigation : Screen()
   object LoginScreen : Screen()
   object MyScreen : Screen()
   object Buttons : Screen()
   object ProgressIndicator : Screen()
   object AlertDialog : Screen()
   object Row : Screen()
   object Column : Screen()
   object Box : Screen()
   object Scaffold : Screen()
}

object Router {
  var currentScreen: MutableState<Screen> = mutableStateOf(Screen.MyScreen)

  fun navigateTo(destination: Screen) {
    currentScreen.value = destination
  }
}