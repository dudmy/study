package example

/**
 * Created by yujin on 2017. 3. 30..
 */
fun main(args: Array<String>) {
    println(max("1".toInt(), "2".toInt()))
    nullCheck()
    println(getStringLength("aaa"))
    println(getStringLength(1))
    exWhileLoop()
    exForLoop()
    exRanges()
    exWhen()
}

/**
 * Use a conditional expression
 */
fun max(a: Int, b: Int) = if (a > b) a else b
// 아래의 함수를 한 줄로 줄이면 위처럼 된다.
//fun example.max(a: Int, b: Int) {
//    if (a > b)
//        return a
//    else
//        return b
//}

/**
 * Null-checks
 */
fun nullCheck() {
    val args = arrayOf("2", "3")

    if (args.size < 2) {
        println("No number supplied")
    } else {
        val x = parseInt(args[0])
        val y = parseInt(args[1])

        if (x != null && y != null) {
            println(x * y)
        } else {
            println("One of the arguments is null")
        }
    }
}
fun parseInt(str: String): Int? {
    // 리턴 타입이 뒤에 붙는다.
    // ? 물음표가 붙는 경우 nullable 을 의미한다.
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        println("One of the arguments isn't Int")
    }
    return null
}

/**
 * is-checks and smart casts
 */
fun getStringLength(obj: Any): Int? {
    // Any 는 자바의 Object 와 비슷한 역할을 한다.
    // is 는 자바의 instanceof 와 비슷한 역할을 한다.
    if (obj is String)
        return obj.length
    return null
}

/**
 * Use a while-loop
 */
fun exWhileLoop() {
    // 일반적인 변수로 값이 변할 수 있다.
    // val 는 자바에서 final 과 비슷한 역할을 하며 값이 변할 수 없다.
    val args = arrayOf("guest1", "guest2", "guest3")

    var i = 0
    while (i < args.size)
        println(args[i++])
}

/**
 * Use a for-loop
 */
fun exForLoop() {
    val args = arrayOf("guest1", "guest2", "guest3")

    for (arg in args)
        println(arg)
//    EXAMPLE IN JAVA
//    for (String arg : args)
//        println(arg)

    // or
    println()
    for (i in args.indices)
        println(args[i])
//    EXAMPLE IN JAVA
//    for (int i = 0; i < args.example.length; i++)
//        println(args[i])
}

/**
 * Use ranges and in
 */
fun exRanges() {
    val x = "4".toInt()
    val y = 10
    if (x in 1..y - 1)
        println("OK")
    // x 와 같이 값이 있는 경우 in 은 contains 역할을 한다.
    // .. 은 ranges 로 1부터 9까지 돌면서 4를 찾고 있으면 OK 를 출력한다.

    for (a in 1..5)
        println("${a} ")
    // a 와 같이 값이 없는 경우 in 은 iterator 역할을 한다.

    println()
    val array = arrayListOf<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")

    if (x !in 0..array.size - 1)
        println("Out: array has only ${array.size} elements. x = ${x}")
    // array 사이즈만큼 돌면서 x 값이 없으면 출력한다.

    if ("aaa" in array)
        println("Yes: array contains aaa")

    if ("ddd" in array)
        println("Yes: array contains ddd")
    else
        println("No: array doesn't contains ddd")
}

/**
 * Use when
 */
fun exWhen() {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}
fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}
class MyClass {
}