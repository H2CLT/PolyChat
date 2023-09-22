package h2clt.fpoly.PolyChat.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import h2clt.fpoly.PolyChat.R
import h2clt.fpoly.PolyChat.model.UserMessage
import h2clt.fpoly.PolyChat.ui.theme.PolyChatTheme
import kotlin.math.roundToInt


@Composable
fun Messages() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF474B57))
    ) {
        HeadTitle(R.string.tin_nhan)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF474B57))
                .padding(start = 16.dp, end = 16.dp)

        ) {
            Space12()
            ButtonChatWithAdmin()
            List()
        }
    }

}
@Composable
fun ButtonChatWithAdmin() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color(0xFF18191E), shape = RoundedCornerShape(15.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(0.15f)
                .height(35.dp)
                .background(Color(0xFF18191E), shape = RoundedCornerShape(25.dp))
                .clickable {
                    Log.e("aa", "Head: Hehe",)
                }
                .padding(start = 10.dp)
            ,

            ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "",
                modifier = Modifier
                    .width(35.dp)
                    .height(35.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(0.85f)
                .height(55.dp)
            ,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = stringResource(id = R.string.admin),
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = stringResource(id = R.string.gioi_thieu4),
                color = Color.White,
                fontSize = 13.sp,
            )
        }
    }
}
@Composable
fun HeadTitle(text:Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .background(color = Color(0xFF18191E)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier
                .width(40.dp)
                .height(55.dp)
                .padding(start = 10.dp)
            ,
            verticalArrangement = Arrangement.Center

        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "",
                tint = Color.White
            )
        }
        Column(
            modifier = Modifier
                .width(200.dp)
                .height(55.dp)
                .padding(start = 10.dp)
            ,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = stringResource(id = text),
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListItem(image:Int,name:String) {

    val squareSize = 50.dp
    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { squareSize.toPx() }
    val anchors = mapOf(0f to 0, -sizePx to 1) // Maps anchor points (in px) to states

    Box(modifier = Modifier
        .fillMaxSize()){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .swipeable(
                    state = swipeableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.3f) },
                    orientation = Orientation.Horizontal
                )
                .background(Color(0xFF474B57), shape = RoundedCornerShape(15.dp))
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF474B57), shape = RoundedCornerShape(15.dp))
                .height(50.dp)
                .padding(end = 16.dp),
                horizontalAlignment = Alignment.End

            ) {
                IconButton(
                    onClick = {
                        Log.e("Xoa", "Xóa")
                    },
                    modifier = Modifier
                        .width(20.dp)
                        .background(Color(0xFF474B57), shape = RoundedCornerShape(15.dp))
                ) {
                    Image(painter = painterResource(id = R.drawable.delete), contentDescription = "",
                        modifier = Modifier
                            .width(45.dp)
                            .height(45.dp)
                    )
                }
            }
            Box(
                Modifier
                    .fillMaxWidth()
                    .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                    .size(squareSize)
                    .background(color = Color(0xFF18191E), shape = RoundedCornerShape(15.dp)),
            ){

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(color = Color(0xFF18191E), shape = RoundedCornerShape(15.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(0.15f)
                            .height(35.dp)
                            .background(Color(0xFF18191E), shape = RoundedCornerShape(25.dp))
                            .clickable {
                                Log.e("aa", "Head: Hehe",)
                            }
                            .padding(start = 10.dp)
                        ,

                        ) {
                        Image(painter = painterResource(id = image), contentDescription = "",
                            modifier = Modifier
                                .width(35.dp)
                                .height(35.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(0.85f)
                            .height(55.dp)

                        ,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = name,
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = stringResource(id = R.string.gioi_thieu5),
                            color = Color.White,
                            fontSize = 13.sp,
                        )
                    }
                }
            }

        }
    }

}
@Composable
fun fakeUserData(): List<UserMessage>{
    val list = mutableListOf<UserMessage>()

    val quoc = UserMessage(image = R.drawable.quoc,name = "Nguyễn Quý Đoàn Quốc")
    val moon = UserMessage(image = R.drawable.moon,name = "Mặt trăng sáng")
    list.add(quoc)
    list.add(moon)

    return list
}

@Composable
fun List() {
    val listUser = fakeUserData()
    LazyColumn(){
        items(listUser){
            user ->
            Space12()
            ListItem(image = user.image, name = user.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewMessages() {
    PolyChatTheme {
        Messages()
    }
}