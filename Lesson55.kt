package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val value = remember { mutableStateOf("") }
            val scope = rememberCoroutineScope()
            val snackHostState = remember { SnackbarHostState() }
            Scaffold (
                snackbarHost = {
                    SnackbarHost(snackHostState){data ->
                        Snackbar(
                            action = {
                                TextButton(onClick = {data.performAction()}) { Text("Принято") }
                            },
                            dismissAction = {
                                IconButton(
                                    onClick = {data.dismiss()}
                                ) {
                                    Icon(Icons.Filled.Close, contentDescription = null)
                                }
                            },
                            content = {
                                Text("Слишком короткий пароль")
                            },
                            containerColor = Color.LightGray,
                            contentColor = Color.DarkGray,
                            actionContentColor = Color.Gray
                        )
                    }
                }
            ) {
                Column (modifier = Modifier
                    .padding(it)
                ) {
                    TextField(
                        value = value.value,
                        onValueChange = {newText ->
                            value.value = newText
                        }
                    )
                    Button(
                        onClick = {
                            if (value.value.length < 8) {
                                scope.launch {
                                    val result = snackHostState.showSnackbar("",
                                        withDismissAction = true,
                                        duration = SnackbarDuration.Short,
                                        actionLabel = "")
                                    if (result == SnackbarResult.ActionPerformed) value.value = ""
                                }
                            }
                        }
                    ) {
                        Text(text = "Подтвердить")
                    }
                }
            }
        }
    }
}


