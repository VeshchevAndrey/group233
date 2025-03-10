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


// МОДИФИКАТОРЫ
// .background(color, shape) - изменяет задний фон элемента
// .height(X.dp) - изменение длины элемента
// .width(X.dp) - изменение ширины элемента
// .fillMaxHeight(Xf) - заполнить длину контейнера (в процентном соотношении)
// .fillMaxWidth(Xf) - заполнить высоту контейнера (в процентном соотношении)
// .fillMaxSize(Xf)  - заполнить весь размер контейнера (в процентном соотношении)
// .size(X.dp, Y.dp) - устанавливает размер по ширине (X) и высоте (Y)
// .heightIn(min = X.dp, max = Y.dp) - задает ограниченный размер по длине
// .widthIn(min = X.dp, max = Y.dp) - задает ограниченный размер по ширине
// .padding(X.dp) - отступ с размером X со всех четырёх сторон
// .padding(X.dp, Y.dp) - отступ с указанием размеров для горизонтальных (X) и вертикальных (Y) сторон
// .padding(Left.dp, Top.dp, Rigth.dp, Bottom.dp) - отступ с указанием размеров для всех 4-ч сторон
// .offset(X.dp, Y.dp) - сдвиг контента на X пикселей по горизонтали и Y пикселей по горизонтали
