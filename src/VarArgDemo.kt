fun sayHello(name: String, vararg lastName: String) {
    lastName.forEach { lastName ->
        println("$name $lastName")

    }
}

fun sayHello1(name: String, lastName: String,surName: String = "Chaluvadi") {
    println("$name $lastName $surName")
}

//SINGLE LINE FUNCTION EXPRESSION
fun getHello() : String = "null"

fun main() {

    sayHello("Ravi")

    //VAL MEANS IMMUTABLE
    val listOf = arrayOf("Varma", "Chaluvadi")

    //* SPREAD OPERATOR CALL FOR LIST TYPE
    sayHello("Ravi", *listOf)
    println(getHello())

    //UNORDERED AND NAMED ARGS CALL
    sayHello1(lastName = "Varma",name="Ravi")

    val person= Person()

    person.printInfo()

}
