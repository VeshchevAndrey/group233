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
import androidx.compose.ui.Modifier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Простой выбор элементов RadioButton
//            val (selected, setSelect) = remember { mutableStateOf("radio1") }
//            Column {
//                RadioButton(
//                    selected = selected == "radio1",
//                    onClick = {setSelect("radio1")}
//                )
//                RadioButton(
//                    selected = selected == "radio2",
//                    onClick = {setSelect("radio2")}
//                )
//                RadioButton(
//                    selected = selected == "radio3",
//                    onClick = {setSelect("radio3")}
//                )
//                RadioButton(
//                    selected = selected == "radio4",
//                    onClick = {setSelect("radio4")}
//                )
//            }
//            val ages = listOf("Меньше 18", "От 18 до 25", "От 25 до 35")
//            val (selectedAge, setSelectedAge) = remember { mutableStateOf(ages[0]) }
//                 Выбор элементов RadioButton с использованием списка и цикла .forEach
//            Column (modifier = Modifier.selectableGroup()) {
//                Text(text = selectedAge)
//                ages.forEach{ age ->
//                    Row() {
//                        RadioButton(
//                            selected = age == selectedAge,
//                            onClick = {setSelectedAge(age)}
//                        )
//                        Text(text = age)
//                    }
//                }
//            }
            // Выбор всех строки с элементом RadioButton
//            Column (modifier = Modifier
//                .selectableGroup()) {
//                ages.forEach{age ->
//                    Row (modifier = Modifier
//                        .selectable(
//                            selected = (age == selectedAge),
//                            onClick = {setSelectedAge(age)}
//                        )){
//                        RadioButton(
//                            selected = (age == selectedAge),
//                            onClick = {setSelectedAge(age)}
//                        )
//                        Text(text = age)
//                    }
//                }
//            }
            val questions = listOf(
                Answer("Мышь", 1),
                Answer("Монитор", 0),
                Answer("Процессор", 0)
            )
            var score = remember { mutableIntStateOf(0) }
            val (selectedAnswer, setSelectedAnswer) = remember { mutableStateOf(questions[0]) }
            Column (modifier = Modifier
                .selectableGroup()){
                questions.forEach{ question ->
                    Row {
                        RadioButton(
                            selected = (selectedAnswer.name == question.name),
                            onClick = {setSelectedAnswer(question)}
                        )
                        Text(text = question.name)
                        }
                    }
                Button(onClick = {score.value += selectedAnswer.score}) {
                    Text("Следующий вопрос")
                    Text(text = score.intValue.toString())
                }
            }
        }
    }
}

data class Answer(val name: String, val score: Int)
