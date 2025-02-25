// Переменные (Variables)

var x: Int = 1 // Переменная с указанием типа данных
var y = 2 // Переменная с самостоятельным определением типа данных
var z: Int = x + y

// Типы переменных
var a: Int = 1 // Тип данных Int
var c: Float = 2.25F // Тип данных Float
var b: Double = 2.25 // Тип данных Double
var s: String = "Hello Kotlin!" // Тип данных String
var s2: Char = 'H' // Тип данных Char
val l: Boolean = true // Логическое значение (true или false)
// Логические операторы
//        && Логическое И (and)
//        || Логическое ИЛИ (or)
//        ! Логическое отрицание (not)
var m = arrayOf(1, 2, 3, 4) // Массив

val w = 100 // Переменная с неизменяемым значением

fun printSum(a: Int, b: Int) {
    println(a + b)
}

fun multNum() {
    var x = readln().toInt() // Перевод строки в целое число
    var y = readln().toInt() // Перевод строки в целое число
    println(x * y)
}

// Математические операторы
fun math() {
//    var x = readln() // Ввод данных в консоль
    var x = 5
    var y = 4
//    var z = x++ // инкремент с увеличением исходного значения, но возвращением первоначального
//    var z = ++x // инремент с увеличением и исходного, и возвращенного значения
    println("x = $x, y = $y")
    println(x + y) // Сложение
    println(x - y) // Вычитание
    println(x * y) // Умножение
    println(x / y) // При делении целых чисел - целое число, при деление дробных - с дробной частью
    println(x % y) // Целочисленное деление с остатком (выводит остаток)

    // совмещённые операторы присвоения и математики
    var a = 5
    var b = 5
    a += b // a = a + b
    println(a)
    a -= b // a = a - b
    println(a)
    a *= b // a = a * b
    println(a)
    a /= b // a = a / b
    println(a)
    a %= b // a = a % b
    println(a)
}

// Условные выражения
fun compare(a: Int, b: Int, c: Int) {
    // операторы сравнения
    println(a > b) // больше, чем
    println(a < b) // меньше, чем
    println(a >= b) // больше, чем или равно
    println(a <= b) // меньше, чем или равно
    println(a == b) // равны
    println(a != b) // не равны
    // логические операторы
    var x = a > c
    var y = b > c
    println(x and y) // Логическое умножение (true, если оба истинны)
    println(x or y) // Логическое сложение (true, если хотя бы одно выражение истинно)
    println(x xor y) // Исключающее ИЛИ (true, если только одно выражение истинно)
    println(!x) // Инверсия (замена значения, true на false, false на true)
    println(5 in 1..10) // true, если операнд находится в последовательности
}
fun compareNum(a: Int, b: Int) {
    // условная конструкция
    if (a > b) {
        println(a)
    }
    else {
        println(b)
    }
}
fun compareNumShort(a: Int, b: Int) {
    // возврат значения через условие
    println(if (a > b) a else b)
}
fun equalOrCompare (a: Int, b: Int) {
    if (a == b) {
        println("Equal values")
    }
    else if (a > b) {
        println(a)
    }
    else {
        println(b)
    }
}
fun equalOrCompareShort(a: Int, b: Int) {
    println(if (a == b) "Equal" else if (a > b) a else b)
}

// Конструкция when
fun autorisation(a: String) {
    when (a) {
        "Администатор" -> println("$a вошел в систему. Даны широкие права доступа")
        "Гость" -> println("$a вошел в систему. Данные не будут сохранены при выходе")
        "Студент" -> println("$a вошел в систему. Права доступа ограничены")
        "Учитель" -> println("$a вошел в систему. Даны стандартные права доступа")
        else -> println("Неавторизированный пользователь. Доступ закрыт.")
    }
}
fun module(a: Int) {
    when {
        (a > 0) -> {
            println("Введено число $a")
            println("Модуль числа $a")
        }
        (a < 0) -> {
            println("Введено число $a")
            val m = a * -1
            println("Модуль числа $m")
        }
        else -> println("Введено неправильное значение или 0")
    }
}
fun age(a: Int){
    when (a) {
        in 0..2 -> println("Младенец")
        in 3..12 -> println("Ребенок")
        in 13..17 -> println("Подросток")
        in 18..29 -> println("Молодой человек")
        else -> println("Неопределенное значение")
    }
}

// Цикл for
fun cycleFor(){
    for (i in 1..10) {
        println(i)
    }
}
fun cycleMath2(){
    for (i in 1..10) {
        println("2 * ${i} = ${i * 2}")
    }
}
fun mathTable(){
    for (i in 1..10) {
        for (j in 1..10){
            println("${i} * ${j} = ${i * j}")
        }
        println()
    }
}
fun cycleArray(){
    var signSet = arrayOf("a", "b", "с")
    for (i in signSet){
        println(i)
    }
}

// Цикл While
fun cycleWhile(){
    var x = 10
    while (x > 0) {
        println(x)
        println(x * x)
        x--
    }
}
fun cycleInf(){
    while (true){
        var x = readln().toInt()
        var y = readln().toInt()
        if (x * y >= 1000000){
            break // преждевременное завершение цикла
        }
        else {
            println(x * y)
        }
    }
}
fun loginPass() {
    while (true) {
        var login = readln()
        var password = readln()
        if ((login == "admin") and (password == "qwerty")) {
            println("Вы успешно вошли в систему!")
            break
        }
        else {
            println("Данные для входа неверны!")
        }
    }
}

// Цикл Do .. While
fun cycleDoWhile(){
    var i = 10
    do {
        println("Я всё ещё работаю!")
        i--
    } while (i > 0)
    println("Я на сегодня всё...")
}

// Оператор continue
fun arrayNum(){
    val a = arrayOf(45, 443, 546, 123, 0, 345, 34, 0, 244, 2442, 0)
    for (i in a) {
        if (i == 0) {
            continue // преждевременно прервать итерацию (повторение) цикла
        }
        println(i)
    }
}

// Диапазон
fun range(){
    var x = 1..5 // Диапазон с увеличением значения
    println(x)
    for (i in x) println(i)

    var y = 5 downTo 1 // Диапазон с уменьшением значения
    println(y)
    for (i in y) println(i)

    var z = 1..10 step 2 // Увеличивающийся диапазон с шагом 2
    println(z)
    for (i in z) println(i)

    var w = 5 downTo 1 step 2 // Уменьшающийся диапазон с шагом 2
    println(w)
    for (i in w) println(i)

    var v = 1 until 10 // Диапазон, исключающий верхнюю границу
    println(v)
    for (i in v) println(i)

    val d = 1..100
    println(10 in d)
    println(200 in d)
    println(101 !in d)
    println(99 !in d)

    var s = 'а'..'я'
    println(s)
    for (i in s) println(i)

    var S = 'А'..'я'
    println(S)
    for (i in S) println(i)

}

// Массивы
fun arrays(){
    var numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5) // Массив с явной типизацией (целочисленный)
    var strings: Array<String> = arrayOf("Hello", "Kotlin", "Android") // Массив с явной типизацией (строковый)

    var mixed = arrayOf(1, 2.4, 3.5f, "4") // Массив с неявной типизацией (смешанный)
    for (i in mixed) println(i)
    println("Четвертый элемент массива = ${mixed[3]}")
    println("Длина массива Mixed = ${mixed.size}") // Возвращение длины массива

    var numbers2 = arrayOf(1, 2, 3, 4, 5) // Массив с неявной типизацией (целочисленный)

    var empty = arrayOfNulls<Int>(10) // Массив пустых значений определённой длинны
    for (i in empty) println(i)
    empty[0] = 100
    for (i in empty) println(i)

    var x = Array(4, {5})
    for (i in x) println(i)

    var y = 1
    var z = Array(10, {y++ * 2})
    for (i in z) println(i)
    println(1 in z)
    println(10 in z)
    println(18 !in z)
    println(21 !in z)
}

// Точка входа (запуска) программы
fun main() {
    arrays()
//    range()
//    arrayNum()
//    cycleDoWhile()
//    loginPass()
//    cycleInf()
//    cycleWhile()
//    cycleArray()
//    mathTable()
//    cycleMath2()
//    cycleFor()
//    age(26)
//    module(0)
//    autorisation("Олег")
//    printSum(x, y)
//    println(m.get(2))
//    math()
//    multNum()
//    compareNum(55, 10)
//    compareNumShort(55, 10)
//    equalOrCompare(12, 11)
//    equalOrCompareShort(12, 11)
}
