package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Stories()
        }
    }
}

@Composable
fun Stories(){
    val users = listOf(Companion("Cloud", R.drawable.i1, "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. "),
        Companion("Tifa", R.drawable.i2, "What's up?"),
        Companion("Aerith", R.drawable.i3, "I'm so sorry..."),
        Companion("Barret", R.drawable.i4, "You are stupid!")
        )

    Column {
        LazyRow (contentPadding = PaddingValues(horizontal = 5.dp, vertical = 2.dp),
            reverseLayout = true, userScrollEnabled = true) {
            itemsIndexed(users) { index, user ->
                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 5.dp)) {
                    Image(
                        bitmap = ImageBitmap.imageResource(user.image),
                        contentDescription = "Avatar",
                        modifier = Modifier
                            .size(75.dp)
                            .clip(CircleShape)
                    )
                    Text(text = user.name)
                }
            }
            item {
                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(horizontal = 7.dp)) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.avatar),
                        contentDescription = "My avatar",
                        modifier = Modifier
                            .size(75.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.FillHeight
                    )
                    Text(text = "My stories")
                }
            }
        }
        LazyColumn(contentPadding = PaddingValues(horizontal = 10.dp)) {
            itemsIndexed(users) {index, user ->
                Row(modifier = Modifier
                    .padding(vertical = 3.dp)
                    .height(75.dp)) {
                    Image(bitmap = ImageBitmap.imageResource(user.image),
                        contentDescription = "Companion Avatar",
                        modifier = Modifier
                            .size(75.dp)
                            .clip(CircleShape))
                    Column(modifier = Modifier
                        .fillMaxHeight(1f)
                        .padding(start = 5.dp)
                        .clickable {  },
                        verticalArrangement = Arrangement.SpaceEvenly) {
                        Text(text = user.name, fontSize = 22.sp,
                            fontWeight = FontWeight.Medium)
                        Text(text = user.lastMessage, fontSize = 17.sp,
                            fontWeight = FontWeight.Light, softWrap = false,
                            overflow = TextOverflow.Ellipsis)
                    }
                }
            }
        }
    }

//    LazyRow {
//        items(5){
//            Text("1")
//        }
//    }
}

data class Companion(val name: String, val image: Int, val lastMessage: String)

@Preview
@Composable
fun TestUI() {

}
