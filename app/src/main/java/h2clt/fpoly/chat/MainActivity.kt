package h2clt.fpoly.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import h2clt.fpoly.chat.app.App
import h2clt.fpoly.chat.router.BackButtonHandler
import h2clt.fpoly.chat.router.Router
import h2clt.fpoly.chat.router.Screen

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

