package h2clt.fpoly.PolyChat.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import h2clt.fpoly.PolyChat.R
import h2clt.fpoly.PolyChat.ui.theme.PolyChatTheme



@Composable
fun ProfileScreenView() {
    val logoAppChat: Painter = painterResource(id = R.drawable.logo_polychat)
    val iconLoop: Painter = painterResource(id = R.drawable.loop)
    val iconXclose: Painter = painterResource(id = R.drawable.x_close)
    val iconPencil: Painter = painterResource(id = R.drawable.pencil)
    val contextForToast = LocalContext.current.applicationContext
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff18191E))
            .padding(start = 5.dp, end = 5.dp)

    ) {
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally // <-- This is changed to End
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        Toast.makeText(contextForToast, "Nhấn cái chó gì", Toast.LENGTH_SHORT)
                            .show()
                    },
                    modifier = Modifier
                        .height(40.dp)
                        .width(140.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    colors = ButtonDefaults.buttonColors(Color(0xffEC194E)),

                    ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = iconPencil, contentDescription = "", Modifier.width(15.dp),
                            Color(0xffffffff)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "Tạo avatar",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color(0xffffffff)
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Card {
                Image(painter = logoAppChat, contentDescription = "", Modifier.width(140.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))

            CustomButton(
                image = iconLoop,
                text = "Ngẫu Nhiên",
                width = 180.dp,
                bgColor = BUTTON_COLOR,
                onClick = { /* Handle click */ }
            )
            Spacer(modifier = Modifier.height(20.dp))
            LayoutOulineText()
            Spacer(modifier = Modifier.height(20.dp))
            CustomButton(
                image = iconXclose,
                text = "Yêu cầu Xóa Tài Khoản",
                width = 300.dp,
                bgColor = BUTTON_COLOR,
                onClick = { /* Handle click */ }
            )
            Spacer(modifier = Modifier.height(60.dp))
            ElevatedButton(
                onClick = {
                    Toast.makeText(contextForToast, "Nhấn cái chó gì", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xffEC194E)),

                ) {
                Text(text = "Lưu Thông Tin", style = TextStyle(fontSize = 25.sp))
            }
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}



@Composable
fun LayoutOulineText() {
    var textName by rememberSaveable { mutableStateOf("Mai Hữu Long") }
    var textEmail by rememberSaveable { mutableStateOf("Longmhph29041@fpt.edu.vn") }
    var textGender by rememberSaveable { mutableStateOf("Nam") }
    var textBio by rememberSaveable { mutableStateOf("Là Cái Chó Gì") }
    OutlinedTextField(
        value = textName,
        onValueChange = { textName = it },
        label = {
            Row {
                Text(text = "Tên Tài Khoản ", color = Color(0xffffffff))
                Text(text = "*", color = Color.Red)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        textStyle = TextStyle(color = Color.White)
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = textEmail,
        onValueChange = { textEmail = it },
        label = {
            Row {
                Text(text = "Email ", color = Color(0xffffffff))
                Text(text = "*", color = Color.Red)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        textStyle = TextStyle(color = Color.White),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = textGender,
        onValueChange = { textGender = it },
        label = {
            Row {
                Text(text = "Giới Tính ", color = Color(0xffffffff))
                Text(text = "*", color = Color.Red)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        textStyle = TextStyle(color = Color.White)
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = textBio,
        onValueChange = { textBio = it },
        label = {
            Row {
                Text(text = "Bio", color = Color(0xffffffff))
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        textStyle = TextStyle(color = Color.White)
    )

}


val REQUIRED_FIELD_COLOR = Color.Red
val LABEL_COLOR = Color(0xffffffff)
val BUTTON_TEXT_COLOR = Color(0xffffffff)
val BUTTON_COLOR = Color(0xff474B57)
val OUTLINE_WIDTH = 2.dp

@Composable
fun CustomButton(image: Painter, text: String, width: Dp, bgColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(bgColor),
        border = BorderStroke(OUTLINE_WIDTH, color = BUTTON_COLOR)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = image, contentDescription = null, Modifier.width(20.dp),
                tint = BUTTON_TEXT_COLOR
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = BUTTON_TEXT_COLOR
                )
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginShopPrevew() {
    PolyChatTheme {
        ProfileScreenView()
    }
}
