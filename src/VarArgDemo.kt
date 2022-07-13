fun sayHello(name: String, vararg lastName: String) {
    lastName.forEach { lastName ->
        println("$name $lastName")

    }
}

fun sayHello1(name: String, lastName: String,surName: String = "Chaluvadi") {
    println("$name $lastName $surName")
}

fun getHello() : String = "null"

fun main() {

    sayHello("Ravi")

    val listOf = arrayOf("Varma", "Chaluvadi")
    sayHello("Ravi", *listOf)
    println(getHello())

    sayHello1(lastName = "Varma",name="Ravi")

    val person= Person()

    person.printInfo()

}
