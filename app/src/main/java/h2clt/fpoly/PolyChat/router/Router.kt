package h2clt.fpoly.PolyChat.router

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
   object Navigation : Screen()
   object LoginScreen : Screen()
   object HomeScreen : Screen()
   object Buttons : Screen()
   object ProgressIndicator : Screen()
   object AlertDialog : Screen()
   object Row : Screen()
   object Column : Screen()
   object Box : Screen()
   object Scaffold : Screen()
}

object Router {
  var currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)

  fun navigateTo(destination: Screen) {
    currentScreen.value = destination
  }
}
