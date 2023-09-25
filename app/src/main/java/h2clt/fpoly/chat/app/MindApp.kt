@file:OptIn(ExperimentalAnimationApi::class)

package com.plcoding.animatedcountercompose

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import h2clt.fpoly.chat.R

@Composable
fun MindScreenApp(
    count: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.headlineLarge
) {
    val arrayValue = arrayOf(
        Pair("Chào mừng bạn đến với PolyChat ❤️","Ấn tiếp tục để xem một số nội quy của ứng dụng"),
        Pair( "Chủ động báo cáo ❗","Những hành vi thiếu lịch sự và gạ tình sẽ bị cấm sử dụng ứng dụng"),
        Pair("Lịch sự và tôn trọng 🔞","Hãy lịch sự và tôn trọng người lạ, những hành vi thiếu lịch sự và gạ tình sẽ bị cấm sử dụng ứng dụng"),
    )

    Row(modifier = modifier) {
        AnimatedContent(
            targetState = arrayValue.getOrNull(count),
            transitionSpec = {
                slideInHorizontally { it } with slideOutHorizontally{ -it }
            }, label = ""
        ) { char ->

            Box(){
                Column(
                    modifier = Modifier
                        .height(88.dp))
                {

                    char?.first?.let {
                        Text(
                            text = it,
                            style = style,
                //                                softWrap = false,
                            color = Color(0xffBB0909),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    if (char != null) {
                        Text(
                            text = char.second,
                //                                softWrap = false,
                            color = Color(0xFF5E5B5B),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }

            }

        }

    }
}
@Composable
fun loadingAnimation() {
    val result: LottieCompositionResult =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation_bee_chat))
    val progressAnnotation by animateLottieCompositionAsState(
        result.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f,
    )
    Column (
        modifier = Modifier.fillMaxSize().padding(bottom = 10.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = result.value, progress = { progressAnnotation }, modifier = Modifier
                .size(150.dp)
        )
    }

}
