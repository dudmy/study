package tutorial

/**
 * Created by yujin on 2017. 4. 4..
 */
fun main(args: Array<String>) {

    println("--Defining functions--")
    println("1 + 2 = ${sum(1, 2)}")
    printSum(2, 3)

    println("\n--Defining local variables")
    localVariables()

    println("\n--Using string templates--")
    stringTemplates()

    println("\n--Using conditional expressions--")
    println(maxOf(1, 2))

    println("\n--Using nullable values and checking for null--")
    printProduct("1", "a")

    println("\n--Using type checks and automatic casts--")
    getStringLength("abc")

    println("\n--Using a for loop--")
    forLoop()

    println("\n--Using a while loop--")
    whileLoop()

    println("\n--Using when expression--")
    println(describe("test"))

    println("\n--Using ranges--")
    ranges()

    println("\n--Using collections--")
    collections()
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

/* SAME
// expression body 를 가질 수 있다.
fun sum(a: Int, b: Int) = a + b
 */

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

/* SAME
// Unit 리턴 타입은 생략 가능
fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}
 */

fun localVariables() {
    val a: Int = 1
    val b = 2 // Int 타입은 추론
    val c: Int // 값을 할당하지 않을 때는 타입을 명시해야함.
    c = 3
}

fun stringTemplates() {
    var a = 1
    val s1 = "a is $a"
    println(s1)

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

/* SAME
fun maxOf(a: Int, b: Int) = if (a > b) a else b
 */

fun parseInt(str: String): Int? { // null 을 리턴할 수 있는 경우 반드시 명시해줘야 한다.
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        return null
    }
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        // null 체크를 한 후에야 non-nullable 로 자동 변환한다.
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 자동으로 String 으로 변환된다.
        return obj.length
    }
    // 여전히 Any 타입
    return null
}

/* SAME
fun getStringLength(obj: Any): Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}

fun getStringLength(obj: Any): Int? {
    if (obj is String && obj.length > 0) {
        // 타입 체크가 완료되면 이미 변환되어 있어 바로 length 체크도 할 수 있다.
        return obj.length
    }
    return null
}
 */

fun forLoop() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun whileLoop() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

// 아직 when expression 에 대해? 쓰임에 대해? 완벽히 이해하지 못함.
fun describe(obj: Any): String =
        when(obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun ranges() {
    val x = 10
    val y = 9
    if (x in 1..y+1) {
        // in 연산자를 이용해 특정 범위 안에 있는지 체크한다.
        println("fits in range")
    }

    // 숫자가 범위 밖인지 체크한다.
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }

    // 범위에 대해 iterating 할 수 있다.
    for (i in 1..5) {
        print(i)
    }
    println()

    // 
    for (i in 1..10 step 2) {
        print(i)
    }
    println()

    for (i in 9 downTo 0 step 3) {
        print(i)
    }
    println()
}

fun collections() {
    // 콜랙션 iterating
    val items = listOf("avocado", "apple" , "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    // 'item in collection' will call 'collection.contains(item)'
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    // 'a'로 시작하는 item 을 필터링 한 후,
    // item 이름을 기준으로 정렬을 한 후,
    // item 을 대문자로 매핑을 한 후,
    // iterating 하면서 item 을 출력한다.
    items.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}