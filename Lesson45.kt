package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

data class User(var name: String, var imageId: Int, var isOnline: Boolean)

@Composable
fun UserRow(user: User){
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .clickable(onClick = {})
            .padding(horizontal = 15.dp, vertical = 2.5f.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(bitmap = ImageBitmap.imageResource(user.imageId), contentDescription = "Avatar",
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )
        Column (modifier = Modifier
            .padding(start = 15.dp)
        ) {
            Text(text = user.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = if (user.isOnline) "Online" else "Offline",
                fontSize = 15.sp)
        }
    }
}

@Composable
fun UserList(users: List<User>){
    LazyColumn {
        itemsIndexed(users){index, item ->
            UserRow(user = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreen(){
    val users = remember {
        listOf(
            User("Cloud Strife", R.drawable.i1, true),
            User("Tifa Lockhart", R.drawable.i2, false),
            User("Aerith Gainsborough", R.drawable.i3, true),
            User("Barret Wallace", R.drawable.i4, false),
        )
    }
    UserList(users)
}

