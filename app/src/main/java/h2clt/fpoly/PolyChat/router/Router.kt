package h2clt.fpoly.PolyChat.router

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
   object Navigation : Screen()
   object LoginScreen : Screen()
   object HomeScreen : Screen()
   object RemindUserScreen : Screen()
    object ProfileScreen : Screen()
    object SplashScreen :Screen()

}

object Router {
 var currentScreen: MutableState<Screen> = mutableStateOf(Screen.HomeScreen)

  fun navigateTo(destination: Screen) {
    currentScreen.value = destination
  }
}
