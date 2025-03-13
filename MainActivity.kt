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

@Composable
fun TestScroll(){
    Text(text = "Задача организации, в особенности же новая модель организационной деятельности " +
            "играет важную роль в формировании существенных финансовых и административных " +
            "условий. Не следует, однако забывать, что консультация с широким активом требуют " +
            "определения и уточнения существенных финансовых и административных условий. " +
            "Идейные соображения высшего порядка, а также постоянный количественный рост и сфера " +
            "нашей активности позволяет оценить значение новых предложений. Значимость этих " +
            "проблем настолько очевидна, что рамки и место обучения кадров требуют от нас " +
            "анализа новых предложений.", fontSize = 25.sp, modifier = Modifier
        .fillMaxHeight(0.5f)
        .fillMaxWidth(1f)
        .verticalScroll(state = ScrollState(0))

        .padding(10.dp)
        .shadow(3.dp)
//        .border(width = 5.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
        .padding(10.dp)
    )
}

@Composable
fun TextButton(text: String){
    Text(text = text, modifier = Modifier
        .shadow(3.dp, RoundedCornerShape(5))
        .background(Color.White, RoundedCornerShape(5))
        .padding(5.dp)
    )
}

@Composable
fun MenuRow(){
    Box(
        modifier = Modifier
            .background(Color.LightGray, RoundedCornerShape(10.dp))
            .fillMaxWidth(1f)
            .fillMaxHeight(0.2f)
            .padding(0.dp, 15.dp)
    ) { Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .horizontalScroll(ScrollState(0))
            .width(500.dp)
    ) {
        TextButton("Фото")
        TextButton("Музыка")
        TextButton("Видео")
        TextButton("Альбомы")
        TextButton("Моменты")
        TextButton("Клипы")
        TextButton("Статьи")
        TextButton("NFT")
    } }

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
