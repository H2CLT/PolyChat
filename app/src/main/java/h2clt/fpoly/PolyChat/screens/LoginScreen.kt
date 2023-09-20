package h2clt.fpoly.PolyChat.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yourcompany.android.jetpackcompose.router.BackButtonHandler
import com.yourcompany.android.jetpackcompose.router.Router
import com.yourcompany.android.jetpackcompose.router.Screen
import h2clt.fpoly.PolyChat.R
import h2clt.fpoly.PolyChat.ui.theme.PolyChatTheme

//class LoginScreen : ComponentActivity(){
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PolyChatTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    homeScreen()
//
//                }
//            }
//        }
//    }
//}

@Composable
fun LoginScreen() {
    val brush = Brush.verticalGradient(listOf(Color(0xFFFEAFAF), Color(0xffFF0000)))
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush)){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        ) {
            loginScreen()
            Spacer(modifier = Modifier.height(40.dp))
            btnLogin()
        }
    }
    BackButtonHandler {
        Router.navigateTo(Screen.Navigation)
    }

}
@Composable
fun loginScreen() {
    Image(
        painterResource(id = R.drawable.logo_polychat),
        contentDescription ="",
    )
    Spacer(modifier = Modifier.height(20.dp))
    Row {
        Text("POLY", style = TextStyle(Color.White, fontSize = 30.sp,fontWeight = FontWeight.Bold))
        Text("CHAT", style = TextStyle(Color(0xffffc78f), fontSize = 30.sp,fontWeight = FontWeight.Bold))

    }

    Spacer(modifier = Modifier.height(20.dp))
    Column (
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ){
        Text(text = "Kết bạn và trò chuyện thú vị", style = TextStyle(Color.Yellow, fontSize = 20.sp,fontWeight = FontWeight.W500))
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Bằng việc đăng nhap và đồng ý với các điều khoản sử dụng và chính sách quyền riêng tư của chúng tôi",
            color = Color.White, textAlign = TextAlign.Center, fontWeight = FontWeight.W500)
    }

}
@Composable
fun btnLogin() {

    Button(onClick = {  },
        colors = ButtonDefaults.buttonColors(
            Color.White,
            contentColor = Color.Red),
        modifier = Modifier.width(300.dp)
    ) {
        Icon(painterResource(id = R.drawable.logo_google)  ,
            contentDescription ="",Modifier.size(16.dp) )
        Text(" Đăng nhập bằng Google", fontSize = 20.sp)    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            Color.White,
            contentColor = Color.Red),
        modifier = Modifier.width(300.dp)
    ) {
        Text(text = "Xem thông tin điều khoản", fontSize = 20.sp)
    }

}



