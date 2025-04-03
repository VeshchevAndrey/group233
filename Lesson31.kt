package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val companions = listOf(Companion("Cloud", R.drawable.i1),
                Companion("Tifa", R.drawable.i2),
                Companion("Aerith", R.drawable.i3),
                Companion("Barret", R.drawable.i4),
                Companion("Cloud", R.drawable.i1),
                Companion("Tifa", R.drawable.i2),
                Companion("Aerith", R.drawable.i3),
                Companion("Barret", R.drawable.i4),
                Companion("Cloud", R.drawable.i1),
                Companion("Tifa", R.drawable.i2),
                Companion("Aerith", R.drawable.i3),
                Companion("Barret", R.drawable.i4),
                Companion("Cloud", R.drawable.i1),
                Companion("Tifa", R.drawable.i2),
                Companion("Aerith", R.drawable.i3),
                Companion("Barret", R.drawable.i4),
                Companion("Cloud", R.drawable.i1),
                Companion("Tifa", R.drawable.i2),
                Companion("Aerith", R.drawable.i3),
                Companion("Barret", R.drawable.i4))
            Column (modifier = Modifier
                .verticalScroll(ScrollState(0))){
                for (companion in companions){
                    Row (verticalAlignment = Alignment.CenterVertically){
                        Image(bitmap = ImageBitmap.imageResource(companion.image),
                            contentDescription = "Avatar", modifier = Modifier
                                .size(75.dp)
                                .clip(CircleShape)
                        )
                        Text(text = companion.name, fontSize = 20.sp,
                            fontWeight = FontWeight.Medium, modifier = Modifier
                                .padding(start = 7.dp))
                    }
                }
            }
        }
    }
}

data class Companion(val name: String, val image: Int)

@Preview
@Composable
fun PreviewTextSwitcher() {

}
