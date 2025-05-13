package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val coroutineScope = rememberCoroutineScope()
//            Row {
//                Button(
//                    onClick = {
//                        coroutineScope.launch {
//                            start()
//                        }
//                    }
//                ) { Text("Нажми на меня!") }
//                Button(
//                    onClick = {
//                        println("Работа начата!")
//                        println("Работа завершена!!")
//                    }
//                ) { Text("И на меня нажми!") }
//            }
            val enable = remember { mutableStateOf(true) }
            Button(
                onClick = {
                    coroutineScope.launch {
                        enable.value = false
                        delay(3000)
                        enable.value = true
                    }
                },
                enabled = enable.value
            ) { Text("Нажми на меня ещё раз!!") }
        }
    }
}

suspend fun start() {
    println("Корутина запущена!")
    delay(3000)
    println("Корутина остановлена!")
}


