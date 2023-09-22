package h2clt.fpoly.PolyChat.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import h2clt.fpoly.PolyChat.R
import h2clt.fpoly.PolyChat.ui.theme.PolyChatTheme


data class BottomNavigationItem(
    val title: Int,
    val selectionImageResId: Int,
    val unselectedImageResId: Int,
    val hasNews: Boolean,
    val badgeCount:Int? = null
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {
    val items = listOf(
        BottomNavigationItem(
            title = R.string.nguoi_la,
            selectionImageResId = R.drawable.peoplepink,
            unselectedImageResId = R.drawable.peoplewhite,
            hasNews = false
        ),
        BottomNavigationItem(
            title = R.string.tin_nhan,
            selectionImageResId = R.drawable.messagepink,
            unselectedImageResId = R.drawable.mesagewhite,
            hasNews = false,
            badgeCount = 45
        ),
        BottomNavigationItem(
            title = R.string.gop_y,
            selectionImageResId = R.drawable.openemailpink,
            unselectedImageResId = R.drawable.openemailwhite,
            hasNews = false
        ),
    )
    var seletedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF18191E)) {
                items.forEachIndexed { index, item ->
                    val isItemSelected = seletedItemIndex == index
                    NavigationBarItem(
                        selected = isItemSelected,
                        onClick = {
                            seletedItemIndex = index
                        },
                        label = {
                            if (isItemSelected) {
                                Text(text = stringResource(id = item.title), color = Color(0xFFE8184F))
                            } else {
                                Text(text = stringResource(id = item.title), color = Color.White)
                            }
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }


                            ) {
                                val imageResId = if (isItemSelected) {
                                    item.selectionImageResId
                                } else {
                                    item.unselectedImageResId
                                }

                                val painter = painterResource(id = imageResId)
                                Image(
                                    painter = painter,
                                    contentDescription = stringResource(id = item.title),
                                    modifier = Modifier
                                        .size(24.dp)
                                )
                            }
                        }
                    )
                }
            }
        }

    ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(color = Color(0xFF101115)),
                contentAlignment = Alignment.TopCenter
            )
            {
                Column()// Padding thanh phan con ben trong column vao 24dp
                {
                    //Tôi muốn sử dụng if else ở đây, hãy chỉ tôi
                    when (seletedItemIndex) {
                        0 -> {
                            Stranger()
                        }
                        1 -> {
                            Messages()
                        }
                        else -> {
                            Feedback()
                        }
                    }
                }
            }
        }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreviewMýcreen() {
    PolyChatTheme {
        HomeScreen()
    }
}
