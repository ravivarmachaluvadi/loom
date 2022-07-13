    //https://kotlinlang.org/docs/keyword-reference.html
    //https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-null-types

    fun main() {

        var a: String = "abc" // Regular initialization means non-null by default

        // a = null // compilation error

        var b: String? = "abc" // can be set to null
        b = null // ok
        print(b?.length)

        println(b!!.toString())
    }
