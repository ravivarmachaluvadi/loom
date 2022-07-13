//PROVIDING DEFAULT VALUES
class Person(val firstName: String = "Ravi", val lastName: String = "Varma") {

    //MUTABLE
    var nickName: String? = null

    init {
        println("Init 1")
    }

    init {
        println("Init 2")
    }

    constructor() : this("Varma", "Ravi") {
        println("Secondary Construtor")
    }

    override fun toString(): String {
        //READING STRING VALUES USING $
        return "Person(firstName='$firstName', lastName='$lastName', nickName=$nickName)"
    }

    fun printInfo() {
        //ELVIS OPERATOR
        val nickNameToPrint = nickName ?: "no nickName"
        println("$firstName ($nickNameToPrint) $lastName")
    }

}
