
package h2clt.fpoly.PolyChat.app

import androidx.compose.animation.Crossfade

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import h2clt.fpoly.PolyChat.router.Router
import h2clt.fpoly.PolyChat.router.Screen
import h2clt.fpoly.PolyChat.screens.HomeScreen
import h2clt.fpoly.PolyChat.screens.LoginScreen
import h2clt.fpoly.PolyChat.screens.LoginShopPrevew
import h2clt.fpoly.PolyChat.screens.ProfileScreenView
import h2clt.fpoly.PolyChat.screens.SplashActivity
import h2clt.fpoly.PolyChat.ui.theme.Purple80
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