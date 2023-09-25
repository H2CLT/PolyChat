
package h2clt.fpoly.chat.app

import androidx.compose.animation.Crossfade

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import h2clt.fpoly.chat.router.Router
import h2clt.fpoly.chat.router.Screen
import h2clt.fpoly.chat.screens.HomeScreen
import h2clt.fpoly.chat.screens.LoginScreen
import h2clt.fpoly.chat.screens.ProfileScreenView
import h2clt.fpoly.chat.screens.SplashActivity
import thanhltph29166.fpt.baithi.test2.Screen.MoveTextAnimation


@Composable
fun App() {
  Surface {
    Crossfade(targetState = Router.currentScreen, label = "") { screenState ->
      when (screenState.value) {
        is Screen.LoginScreen -> LoginScreen()
        is Screen.HomeScreen -> HomeScreen()
        is Screen.RemindUserScreen -> MoveTextAnimation()
        is Screen.SplashScreen -> SplashActivity()
        is Screen.ProfileScreen -> ProfileScreenView()


        else -> {}
      }
    }
  }
}