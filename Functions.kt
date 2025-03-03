// Функции
fun main () {
    val x = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 1)
    mult2(*x)
//    println(summ(sqr(5), sqr(6)))
//    employee("Преподаватели", "Иванов", "Сергеев", "Василенко", "Давыдова", salary = 50000)
//    printHello()
//    student("Андрей", 16)
//    student("Олег", 20, 4)
}

fun printHello() {
    println("Hello ${sayMyName()}!")
}
fun sayMyName(): String{
    var name = readln()
    return name
}
fun summ(x: Int, y: Int): Int {
    return x + y
}
fun sqr(x: Int): Int {
    return x * x
}
fun student(name: String, age: Int, course: Int=1){
    println("Студент: $name, возраст: $age, курс: $course")
}

fun employee(post: String, vararg surnames: String, salary: Int){
    println("Должность: $post")
    println("Зарплата: $salary")
    println("Сотрудники:")
    for (i in surnames) println(i)
}
fun mult2(vararg x: Int){
    for (i in x) println(i * 2)
}