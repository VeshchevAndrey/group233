package com.example.group233

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.trace
import com.example.group233.ui.theme.Group233Theme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Group233Theme {

            }
        }
    }
}

@Composable
fun TestLogin(){
    val login = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth(1f)
    ) {
        Text(text = "Enter your login:",
            modifier = Modifier
                .padding(0.dp) // Внешний отступ
                .padding(5.dp), // Внутренний отступ
            fontSize = 25.sp,
            color = Color(0xFF0D47A1),
            fontStyle = FontStyle.Normal, // Курсив (Italic)
            fontWeight = FontWeight.Medium, // Толщина шрифта
            fontFamily = FontFamily.SansSerif, // Вид шрифта
            textDecoration = TextDecoration.None, // Подчёркивание шрифта
            letterSpacing = 0.sp, // Расстояние между буквами
            textAlign = TextAlign.Right, // Выравнивание текста
            style = TextStyle(textIndent = TextIndent(5.sp)) // Красная строка
        )
        OutlinedTextField(value = login.value,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp, 5.dp),
            onValueChange = { newText -> login.value = newText },
            label = { Text("Login") },
            placeholder = { Text("Login/E-mail/Phone", fontSize = 25.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            trailingIcon = { IconButton(onClick = { login.value = "" }) {
                Icon(Icons.Filled.Delete, contentDescription = "Clear field")
                } },
            textStyle = TextStyle(fontSize = 25.sp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Black,
                focusedBorderColor = Color(0xFF0D47A1),
                focusedLabelColor = Color(0xFF0D47A1),
                focusedContainerColor = Color(0xFFC5BBBB)
            ),
            prefix = { Text("+7", fontSize = 25.sp) }
        )
        Button(onClick = { },
            modifier = Modifier.padding(10.dp, 5.dp),
            enabled = true,
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0D47A1)
            ),
            border = BorderStroke(1.dp, Color.Black),
            contentPadding = ButtonDefaults.TextButtonContentPadding
            ) { Text("Login", fontSize = 25.sp) }
    }
}

@Preview(showBackground = true)
@Composable
fun TestUIPreview(){
    TestLogin()
}
