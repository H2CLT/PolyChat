package h2clt.fpoly.PolyChat.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import h2clt.fpoly.PolyChat.R
import h2clt.fpoly.PolyChat.ui.theme.PolyChatTheme

class PolyMessenger : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PolyChatTheme {
               ChatView()
            }
        }
    }
}
data class Message(val content: String, val isSender: Boolean)



@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChatView() {
    val keyboardController = LocalSoftwareKeyboardController.current
    val background: Painter = painterResource(R.drawable.backgroud_app_chat)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff18191E))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Box(
                modifier = Modifier
                    .weight(0.09f)
                    .fillMaxSize()
            ) {
                Tabbar("LongBoiz", "Kênh CNTT")
            }
            Box(
                modifier = Modifier
                    .weight(0.82f)
                    .fillMaxSize()
            ) {
                Image(
                    painter = background,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                AppChatPoly(testMessages)
            }

            Box(
                modifier = Modifier
                    .weight(0.09f)
                    .fillMaxSize()
                    .background(Color(0xff18191E))
                    .padding(top = 15.dp),
            ) {
                TabBottomView()
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}


// thanh tabbar trên cùng
@Composable
fun Tabbar(name: String, kenh: String) {
    val iconLeft: Painter = painterResource(id = R.drawable.left_arrow)
    val imageAcout: Painter = painterResource(id = R.drawable.logo_polychat)
    val iconInfo: Painter = painterResource(id = R.drawable.info)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff18191E))
    ) {
        Box(
            modifier = Modifier
                .weight(0.1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            Alignment.Center
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = iconLeft, contentDescription = "", colorFilter = ColorFilter.tint(
                        Color.White
                    )
                )
            }

        }
        Box(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth()
                .fillMaxHeight(),
            Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        2.dp,
                        Color(0xffBB0909),
                        CircleShape
                    )
                    .clip(CircleShape)
                    .background(Color.Gray),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Image(painter = imageAcout, contentDescription = "", Modifier.size(50.dp))
            }
        }
        Box(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = kenh,
                    style = TextStyle(
                        color = Color(0xffA39999),
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                )

            }
        }
        Box(
            modifier = Modifier
                .weight(0.15f)
                .fillMaxWidth()
                .fillMaxHeight(),
            Alignment.Center
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Image(
                    painter = iconInfo,
                    contentDescription = "",
                    Modifier.size(30.dp),
                    colorFilter = ColorFilter.tint(
                        Color.White
                    )
                )
            }
        }
    }
}


// phần hiển thị tin nhắn cùng
@Composable
fun AppChatPoly(messages: List<Message>) {
    //LazyColumn hoạt động giống như RecyclerView trong Android gốc
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        items(messages) { message ->
            MessageItem(message)
        }
    }
}


@Composable
fun MessageItem(message: Message) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
    ) {
        if (message.isSender) {
            Text(
                text = message.content,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .background(Color(0xffE34C3D), shape = RoundedCornerShape(8.dp))
                    .padding(8.dp),
                color = Color.White
            )
        } else {
            Text(
                text = message.content,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }
    }
}

// Test dữ liệu
val testMessages = listOf(
    Message("Xin chào!", false),
    Message("Chào bạn, bạn đang làm gì vậy?", true),
    Message("Mình đang học lập trình.", false),
    Message("Tuyệt vời!", true),
    Message("Xin chào!", false),
    Message("Chào bạn, bạn đang làm gì vậy?", false),
    Message("Mình đang học lập trình.", true),
    Message("Tuyệt vời!", true),
    Message("Xin chào!", false),
    Message("Chào bạn, bạn đang làm gì vậy?", true),
    Message("Mình đang học lập trình.", false),
    Message("Tuyệt vời!", true),
    Message("Tuyệt vời!", true),
    Message("Mình đang học lập trình.", false),

    )


//Thanh tabBottom thanh dưới cùng
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TabBottomView() {
    val iconFab: Painter = painterResource(id = R.drawable.add)
    val iconPicture: Painter = painterResource(id = R.drawable.pictures)
    val iconPaper: Painter = painterResource(id = R.drawable.paper_plane)
    val iconRight: Painter = painterResource(id = R.drawable.icon_right)
    val size: Dp = 23.dp
    var isFocused by remember { mutableStateOf(false) }
    var isTextFieldActive by remember { mutableStateOf(true) }
    Row(
        Modifier
            .fillMaxWidth()
            .pointerInput(Unit) { // Sử dụng pointerInput để nhận biết sự kiện nhấn
                detectTapGestures(onTap = {
                    // Khi nhấn vào, thiết lập TextField thành không kích hoạt
                    isTextFieldActive = false
                })
            }
    ) {
        // Chỉ hiển thị 2 IconButton này khi TextField không được focus
        if (!isFocused) {
            Row(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxWidth()
                    .padding(0.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = iconFab, contentDescription = "", Modifier.size(size), colorFilter = ColorFilter.tint(
                        Color.Red
                    ))
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = iconPicture, contentDescription = "", Modifier.size(size), colorFilter = ColorFilter.tint(
                        Color.Red
                    ))
                }
            }
        } else {
            IconButton(onClick = {
                isFocused = !isFocused
            }) {
                Image(painter = iconRight, contentDescription = "", Modifier.size(size), colorFilter = ColorFilter.tint(
                    Color.Red
                ))
            }
        }
        Column(
            modifier = Modifier
                .weight(7f)
                .fillMaxWidth()
                .padding(horizontal = 2.dp)
        ) {
            if (isTextFieldActive) { // Chỉ hiển thị TextField khi nó được kích hoạt
                TextFiledLayout(onFocusChanged = { isFocused = it })
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            IconButton(onClick = {} ) {
                Image(painter = iconPaper, contentDescription = "", Modifier.size(size), colorFilter = ColorFilter.tint(
                    Color.Red
                ))
            }
        }
    }
}

@Composable
fun TextFiledLayout(onFocusChanged: (Boolean) -> Unit, placeholder: String = "Nhập Nội Dung") {
    var value by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .height(60.dp)  // Giới hạn chiều cao của Box
            .fillMaxSize()
            .padding(horizontal = 7.dp, vertical = 7.dp),
    ) {
        if (value.isEmpty()) {
            Text(
                text = placeholder,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xffA39999)
            )
        }
        BasicTextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            // Cập nhật trạng thái focus khi có sự thay đổi
            modifier = Modifier.onFocusChanged { onFocusChanged(it.isFocused) },
            textStyle = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatPriview() {
    PolyChatTheme {
          ChatView()
    }
}