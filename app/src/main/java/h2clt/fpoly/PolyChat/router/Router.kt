package h2clt.fpoly.PolyChat.router

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
   object Navigation : Screen()
   object LoginScreen : Screen()
    object RemindUserScreen : Screen()
   object HomeScreen : Screen()
    object ProfileScreen : Screen()
   object Buttons : Screen()
   object ProgressIndicator : Screen()
   object AlertDialog : Screen()
   object Row : Screen()
   object Column : Screen()
   object Box : Screen()
   object Scaffold : Screen()
}

object Router {
  var currentScreen: MutableState<Screen> = mutableStateOf(Screen.ProfileScreen)

  fun navigateTo(destination: Screen) {
    currentScreen.value = destination
  }
}
