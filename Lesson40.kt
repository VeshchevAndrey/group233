fun main() {
//    var comp1 : Companion = Companion()
//    comp1.name = "Andrey"
//    comp1.lastMessage = "Hello!"
//    comp1.id = 1
//    println(comp1.name)
//    println(comp1.lastMessage)
//    comp1.printLastMessage()
//    comp1.timeLastMessage("10:00")
//    println(comp1.nameCompanion())
//    var comp2 : Companion = Companion()
//    var comp3 : Companion = Companion()
//    val user1 = User("veshchev")
//    val user2 = User("Андрей Вещев", "veshchev", 26)
//    val user3 = User("admin", "Администратор")
//    val group1 = Group("Students", 20)
//    val log1 = AuthorizationData("admin", "password")
//    println(log1.password)
//
//    val mem1 : GroupsMember = GroupsMember("User", 1, "01.01.2025")
//    println(mem1.writeMessage("Hello!"))
//    val adm1 : GroupsAdmin = GroupsAdmin("Admin", 2, "01.01.2025")
//    println(adm1.writeMessage("Hello!!!"))
//    println(adm1.changeGroupsName("New Name!"))
//
//    val person1: Person = Person("Andrey")
//    println(person1.age)
//    person1.display()
//    val person2: Adult = Adult("Andrey")
//    println(person2.age)
//    person2.display()
//    val person3: Employee = Employee("Andrey", "Google")
//    println(person2.age)
//    person3.display()
   val stud1 = Student("Андрей", 1)
   stud1.display()
   stud1.course = -1
   stud1.display()
   stud1.course = 5
   stud1.display()
   println(stud1.course)
   println(stud1.studentName)
   val med1 = Medic("Василиса", 6)
   println(med1.studentName)
}

// Объявление класса
//class Companion
class Companion {
   val id : Int = 0
   var name : String = "No name"
   var lastMessage : String = "Last Message"

   fun printLastMessage(){
       println("$name send message: $lastMessage")
   }
   fun timeLastMessage(time: String){
       println("Time: $time")
   }
   fun nameCompanion(): String{
       return "Name: $name"
   }
}

//Вторичный конструктор
//class User{
//    var name : String = "Name"
//    var age : Int = 0
//
//    constructor(_name : String, _age : Int){
//        name = _name
//        age = _age
//    }
//}

// Первичный конструктор
//class User(_name: String, _age: Int) {
//    var name : String = _name
//    var age : Int = _age
//}

class User(_nickname: String){
   var name : String = "Name"
   var nickname: String = _nickname
   var age : Int = 0

//    constructor(_nickname: String){
//        nickname = _nickname
//    }
//
//    constructor(_name: String, _nickname: String, _age: Int){
//        name = _name
//        nickname = _nickname
//        age = _age
//    }

   constructor(_name: String, _nickname: String): this(_nickname){
       name = _name
   }

   constructor(_name: String, _nickname: String, _age: Int): this(_nickname, _name){
       age = _age
   }
}

class Group(var name: String, var members: Int)

class AuthorizationData(_login: String, _password: String){
   var login : String = ""
   var password : String = ""

   init {
       login = _login
       if (_login != _password) password = _password
   }

}

// Открытый для наследования класс
//open class GroupsMember{
//    var name : String = ""
//    var avatarID : Int = 0
//    var joined: String = ""
//
//    constructor(_name: String, _avatarID: Int, _joined: String){
//        name = _name
//        avatarID = _avatarID
//        joined = _joined
//    }
//
//    fun writeMessage(message: String): String{
//        return message
//    }
//}

open class GroupsMember(_name: String, _avatarID: Int, _joined: String) {
   var name : String = _name
   var avatarID : Int = _avatarID
   var joined: String = _joined

   fun writeMessage(message: String): String{
       return message
   }
}

class GroupsAdmin(admName: String,
               admAvID: Int,
               admJoined: String): GroupsMember(admName, admAvID, admJoined){
                   var isOnline : Boolean = false

   constructor(admName: String, admAvID: Int, admJoined: String, _isOnline: Boolean): this(admName, admAvID, admJoined){
       isOnline = _isOnline
   }

   fun changeGroupsName(newName: String): String{
       return newName
   }
}

//class GroupsAdmin: GroupsMember{
//    constructor(admName: String,
//                admAvID: Int,
//                admJoined: String): super(admName, admAvID, admJoined)
//}

open class Person(_name: String){
   var name: String = _name
   open var age: Int = 0
   open fun display(){
       println("Name: $name")
   }
}

open class Adult(_name: String): Person(_name){
   override var age: Int = 18
   override fun display() {
       println("Name: $name, age: $age")
   }
}

class Employee(_name: String, _company: String): Adult(_name){
   var company: String = _company
   override fun display() {
       println("Name: $name, age: $age, company: $company")
   }
}

// Работа с сеттером
open class Student(_name: String, _course: Int){
   var name = _name
//        get() {
//            println("Имя студента:")
//            return field
//        }
   open var course = _course
       set(value) {
           if ((value > 1) and (value < 5)){
               field = value
           }
       }

   open val studentName: String = _name
       get(){
           return "Имя студента: $field"
       }

   fun display(){
       println("$name, $course")
   }
}

class Medic(_name: String, _course: Int): Student(_name, _course){
   override var course = _course
       set(value){
           if ((value > 1) and (value < 7)){
               field = value
           }
       }
   override val studentName: String = _name
       get() {
           return "Имя студента-медика: $field"
       }
}

Абстрактные классы
abstract class Figure{
   abstract fun P(): Float
   abstract fun S(): Float
}

class Square(_length: Float): Figure(){
   var length = _length

   override fun P(): Float {
       return length * 4
   }

   override fun S(): Float {
       return length * length
   }
}
