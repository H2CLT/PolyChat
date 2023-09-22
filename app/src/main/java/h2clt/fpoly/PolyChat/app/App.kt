
package h2clt.fpoly.PolyChat.app

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import h2clt.fpoly.PolyChat.router.Router
import h2clt.fpoly.PolyChat.router.Screen
import h2clt.fpoly.PolyChat.screens.HomeScreen
import h2clt.fpoly.PolyChat.screens.LoginScreen
import h2clt.fpoly.PolyChat.screens.ProfileScreen
import h2clt.fpoly.PolyChat.ui.theme.Purple80
import thanhltph29166.fpt.baithi.test2.Screen.MoveTextAnimation


@Composable
fun App() {
  Surface(color = Purple80) {
    Crossfade(targetState = Router.currentScreen, label = "") { screenState ->
      when (screenState.value) {
        is Screen.LoginScreen -> LoginScreen()
        is Screen.HomeScreen -> HomeScreen()
        is Screen.RemindUserScreen -> MoveTextAnimation()
        is Screen.ProfileScreen -> ProfileScreen()


        else -> {}
      }
    }
  }
}