package thanhltph29166.fpt.baithi.test2.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.animatedcountercompose.MindScreenApp
import com.plcoding.animatedcountercompose.loadingAnimation
import com.yourcompany.android.jetpackcompose.router.Screen
import h2clt.fpoly.PolyChat.ui.theme.AnimatedCounterComposeTheme


@Composable
fun MoveTextAnimation() {
    val brush = Brush.verticalGradient(listOf(Color(0xFFFEAFAF), Color(0xffFF0000)))

    AnimatedCounterComposeTheme {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Card(
                    modifier = Modifier
                        .width(400.dp)
                        .height(150.dp),

                    border = BorderStroke(2.dp, Color(0xffffffff)),
                    colors = CardDefaults.cardColors(containerColor = Color(0xffffffff))
                ) {

                    Column( modifier = Modifier.padding(start = 12.dp)) {
                        var count by remember {
                            mutableStateOf(0)
                        }
                        MindScreenApp(
                            count = count,
                            style = MaterialTheme.typography.headlineLarge
                        )
                        ElevatedButton(
                            onClick = { count++ },
                            modifier = Modifier.width(130.dp),
                            colors = ButtonDefaults.buttonColors( Color(0xffEC194E)) // Đặt màu nền tại đây
                        ) {
                            Text(text = "Tiếp tục ", fontSize = 20.sp)
                        }
                        Spacer(modifier = Modifier.height(7.dp))
                    }
                }

                loadingAnimation()


            }
        }
    }
}