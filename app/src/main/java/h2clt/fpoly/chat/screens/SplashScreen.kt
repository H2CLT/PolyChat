package h2clt.fpoly.chat.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import h2clt.fpoly.chat.R
import h2clt.fpoly.chat.router.Router
import h2clt.fpoly.chat.router.Screen
import h2clt.fpoly.chat.ui.theme.PolyChatTheme
import java.util.Timer
import kotlin.concurrent.schedule


@Composable
fun SplashActivity() {
    val brush = Brush.verticalGradient(listOf(Color(0xFFFEAFAF), Color(0xffFF0000)))
    val image: Painter = painterResource(id = R.drawable.logo_polychat)

    Box(modifier = Modifier
        .background(brush)
        .fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Phần 2/3 ở trên
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = image, contentDescription = "", Modifier.width(100.dp))
            }

            // Phần 1/3 ở dưới
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                loadingAnimation()
                SideEffect {
                    Timer("loading", false).schedule(5000){
                        Router.navigateTo(Screen.RemindUserScreen)
                    }

                }
                }
            }
        }
    }


@Composable
fun loadingAnimation() {
    val result: LottieCompositionResult =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.loading))
    val progressAnnotation by animateLottieCompositionAsState(
        result.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 0.5f,
    )
    LottieAnimation(
        composition = result.value, progress = { progressAnnotation }, modifier = Modifier
            .size(250.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
     PolyChatTheme {
        SplashActivity()
    }
}
