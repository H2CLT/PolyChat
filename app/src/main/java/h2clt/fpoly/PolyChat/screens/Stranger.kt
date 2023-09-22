package h2clt.fpoly.PolyChat.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import h2clt.fpoly.PolyChat.R
import h2clt.fpoly.PolyChat.router.Router
import h2clt.fpoly.PolyChat.router.Screen
import h2clt.fpoly.PolyChat.ui.theme.PolyChatTheme
@Composable
fun Stranger() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Head()
        Space()
        Point()
        Space()
        User()
        Space12()
        Introduce()
        Space12()
        TextChat()
        ChatChannels()
    }
}
@Composable
fun Head(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)

    ) {
        Column(
            modifier = Modifier
                .weight(0.8f)
                .height(60.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                stringResource(R.string.app_name),
                color = Color.White,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                stringResource(R.string.gioi_thieu),
                color = Color.White,
                fontSize = 14.sp,

            )
        }
        Column(
            modifier = Modifier
                .weight(0.2f)
                .height(60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {

            Column(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(Color.Red, shape = RoundedCornerShape(25.dp))
                    .clickable {
                        Log.e("aa", "Head: Hehe",)
                    },
            ) {
                Image(painter = painterResource(id = R.drawable.moon), contentDescription = "",
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )

            }
        }

    }
}
@Composable
fun Point(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(160.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
            Column(modifier = Modifier
                .weight(0.3f)
                .height(160.dp)
                .background(Color(0xFF2D2338), shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

                ) {
                Image(painter = painterResource(id = R.drawable.message), contentDescription = "",
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                    )
                Text(
                    text = "1000",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8D44AD)
                )
                Text(
                    text = "người online",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF8D44AD)
                )
            }

        Box(modifier = Modifier
            .weight(0.01f)
            .height(160.dp))

            Column(modifier = Modifier
                .weight(0.3f)
                .height(160.dp)
                .background(Color(0xFF383320), shape = RoundedCornerShape(16.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(painter = painterResource(id = R.drawable.people1), contentDescription = "",
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                )
                Text(
                    text = "20",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFBBC05)
                )
                Text(
                    text = "người đã match",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFBBC05)
                )
            }
    }
}
@Composable
fun User() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)

    ) {

        Column(
            modifier = Modifier
                .weight(0.1f)
                .height(55.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(Color(0xFF18191E), shape = RoundedCornerShape(25.dp))
                    .clickable {
                        Log.e("aa", "Head: Hehe",)
                    },
            ) {
                Image(painter = painterResource(id = R.drawable.quoc), contentDescription = "",
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )

            }
        }
        Column(
            modifier = Modifier
                .weight(0.5f)
                .height(55.dp)
                .padding(start = 8.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = "Nguyễn Cao Cường",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                stringResource(R.string.mieu_ta),
                color = Color.White,
                fontSize = 14.sp,
                )
        }
        Column(
            modifier = Modifier
                .weight(0.3f)
                .height(55.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .width(130.dp)
                    .height(30.dp)
                    .background(Color(0xFFEB194E), shape = RoundedCornerShape(10.dp))
                    .clickable { Router.navigateTo(Screen.ProfileScreen)}
                ,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Spacer(modifier = Modifier.width(3.dp)) // Tao ra khoang trong giua hai text
                Icon(Icons.Default.Edit, contentDescription = "", tint = Color.White, modifier = Modifier.width(18.dp).height(18.dp))
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    stringResource(R.string.chinh_sua),
                    color = Color.White,
                    fontSize = 15.sp,
                    modifier = Modifier.width(90.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
@Composable
fun Introduce() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(Color(0xFFEB194E), shape = RoundedCornerShape(5.dp)),
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            stringResource(R.string.gioi_thieu2),
            modifier = Modifier.padding(start = 10.dp),
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun TextChat() {
        Text(
            stringResource(R.string.gioi_thieu3),
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold

        )
}
@Composable
fun ChatChannel(text1:Int,image1:Int,text2:Int,image2:Int){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(0.3f)
                .height(50.dp)
                .background(Color(0xFF2D2C2A), shape = RoundedCornerShape(16.dp))
                .clickable {},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = image1), contentDescription = "",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(start = 5.dp)
            )
            Text(text = stringResource(id = text1),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        Spacer(modifier = Modifier.weight(0.01f))
        Row(
            modifier = Modifier
                .weight(0.3f)
                .height(50.dp)
                .background(Color(0xFF2D2C2A), shape = RoundedCornerShape(16.dp))
                .clickable {},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = image2), contentDescription = "",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(start = 5.dp)
            )
            Text(text = stringResource(id = text2),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}
@Composable
fun ChatChannels() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ChatChannel(text1 = R.string.cong_dong, image1 = R.drawable.people2, text2 = R.string.cntt, image2 = R.drawable.cntt)
        ChatChannel(text1 = R.string.marketing, image1 = R.drawable.marketing, text2 = R.string.tkdh, image2 = R.drawable.tkdh)
        ChatChannel(text1 = R.string.logistic, image1 = R.drawable.logistic, text2 = R.string.tu_dong_hoa, image2 = R.drawable.tudonghoa)

    }
}

@Composable
fun Space(){
    Spacer(modifier = Modifier.height(6.dp)) // Tao ra khoang trong giua hai text
}
@Composable
fun Space12(){
    Spacer(modifier = Modifier.height(12.dp)) // Tao ra khoang trong giua hai text
}
@Preview(showBackground = true)
@Composable
fun GreetingPreviewHomeScreen() {
    PolyChatTheme {
        Stranger()
    }
}


