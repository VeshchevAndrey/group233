package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val characters = listOf("Cloud Strife",
                "Tifa Lockhart",
                "Aerith Gainsborough",
                "Barret Wallace")
            val charImage = listOf(R.drawable.i1,
                R.drawable.i2,
                R.drawable.i3,
                R.drawable.i4)
            val pagerState = rememberPagerState { characters.size }
            val scope = rememberCoroutineScope()
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize(1f)
            ) {
                Text(text = "Досье персонажа", fontSize = 30.sp)
                HorizontalPager(
                    state = pagerState
                ) {page ->
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                    ) {
                        Image(
                            bitmap = ImageBitmap.imageResource(charImage[page]),
                            contentDescription = "Character Image",
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                        )
                        Text(text = characters[page], fontSize = 28.sp)
                    }
                }
                Row {
                    IconButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "Keyboard Arrow Left")
                    }
                    for (char in characters) {
                        TextButton(
                            onClick = {
                                scope.launch {
                                    pagerState.scrollToPage(characters.indexOf(char))
                                }
                            }
                        )  {
                            Text(text = "${characters.indexOf(char) + 1}")
                        }
                    }
                    IconButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Keyboard Arrow Right")
                    }
                }
            }
        }
    }
}
