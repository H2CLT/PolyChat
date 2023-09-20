
package h2clt.fpoly.PolyChat.app

import androidx.compose.animation.Crossfade

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable

import com.yourcompany.android.jetpackcompose.router.Router
import com.yourcompany.android.jetpackcompose.router.Screen
import h2clt.fpoly.PolyChat.screens.LoginScreen
import h2clt.fpoly.PolyChat.screens.MyScreen
import h2clt.fpoly.PolyChat.ui.theme.Purple80


@Composable
fun App() {
  Surface(color = Purple80) {
    Crossfade(targetState = Router.currentScreen, label = "") { screenState ->
      when (screenState.value) {
        is Screen.LoginScreen -> LoginScreen()
        is Screen.MyScreen -> MyScreen()


        else -> {}
      }
    }
  }
}