// Изменение цвета и размера блока при помощи модификаторов .size и .background
@Composable
fun TestModifier() {
    val myColor: Color = Color(0xFFFF7100)
    Text(text = "Тут что-то будет!", modifier = Modifier
        .background(myColor, RoundedCornerShape(0))
        .size(100.dp)
    )
}

// Создание внешних и внутренних отступов при помощи .padding
@Composable
fun TestOffset() {
    Column {
        Text(text = "Это первый текст!", modifier = Modifier
            .width(150.dp)
            .padding(5.dp)
            .background(Color.Gray)
            .padding(5.dp)
        )
        Text(text = "Это второй текст!", modifier = Modifier
            .width(150.dp)
            .padding(5.dp)
            .background(Color.DarkGray)
            .padding(5.dp)
        )
    }
}
