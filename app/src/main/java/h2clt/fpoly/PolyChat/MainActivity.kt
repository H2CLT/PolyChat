package h2clt.fpoly.PolyChat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import h2clt.fpoly.PolyChat.app.App
import h2clt.fpoly.PolyChat.router.BackButtonHandler
import h2clt.fpoly.PolyChat.router.Router
import h2clt.fpoly.PolyChat.router.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           App()
            BackButtonHandler {
                Router.navigateTo(Screen.HomeScreen)
            }
        }

    }
}

