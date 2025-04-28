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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val FABisClick = remember { mutableStateOf(false) }
            val snackbarState = remember { SnackbarHostState() }
            val scope = rememberCoroutineScope()
            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(text = "Моё приложение")
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
                    )
                },
                bottomBar = {
                    BottomAppBar (
                        containerColor = Color.LightGray
                    ){
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Person, contentDescription = "Person")
                        }
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {
                        FABisClick.value = !FABisClick.value
                    },
                        shape = CircleShape,
                        containerColor = Color(0xff0088cc),
                        contentColor = Color.White
                    ) {
                        if (FABisClick.value) Icon(Icons.Filled.Add, contentDescription = "Add")
                        else Icon(Icons.Filled.Create, contentDescription = "Create")
                    }
                },
                floatingActionButtonPosition = FabPosition.End,
                snackbarHost = {
                    SnackbarHost(snackbarState)
                }
            ) {
                Text(text = "Привет Сосед!", modifier = Modifier
                    .padding(it)
                    .clickable (
                        onClick = {
                            scope.launch {
                                snackbarState.showSnackbar("Текст нажат!") }
                        }
                    )
                )
            }
        }
    }
}

