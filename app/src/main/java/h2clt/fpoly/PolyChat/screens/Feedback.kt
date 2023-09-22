package h2clt.fpoly.PolyChat.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.res.stringResource
import h2clt.fpoly.PolyChat.R
import h2clt.fpoly.PolyChat.ui.theme.PolyChatTheme


@Composable
fun Feedback() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF474B57))
    ) {
        HeadTitle(R.string.gop_y)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF474B57))
                .padding(start = 16.dp, end = 16.dp),


        ) {
            Space12()
            Space12()
            Text(
                text = stringResource(id = R.string.loi_gop_y),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Space12()
            Space12()
            LongTextFieldDemo()
            Space12()
            Space12()
            ButtonSend()


        }
    }
}

@Composable
fun LongTextFieldDemo() {
    var text by rememberSaveable {
        mutableStateOf("Nhập nội dung...")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color(0xFF18191E), shape = RoundedCornerShape(16.dp))
            .padding(10.dp)
    ) {
        Icon(Icons.Default.Edit, contentDescription = "", tint = Color.White,)
        BasicTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFF18191E), shape = RoundedCornerShape(16.dp))
                .padding(start = 5.dp)
            ,
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        )
    }
}

@Composable
fun ButtonSend() {
    Button(onClick = { /*TODO*/ },
    colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFFEB194E),
        contentColor = Color.White
    ),
    modifier = Modifier
        .fillMaxWidth()
        .height(40.dp),
            shape = RoundedCornerShape(16.dp),
    ) {
        Text(text = stringResource(id = R.string.gui))
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreviewSuggest() {
    PolyChatTheme {
        Feedback()
    }
}