package example

/**
 * Created by yujin on 2017. 4. 2..
 */
fun main(args: Array<String>) {

    println("--Reference to a function--")
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))

    println("\n--Composition of functions--")
    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))

    val composed = compose2(::addTen, ::mulTwo)
    println(composed(2))

    val composed2 = compose2({ a: Int -> a + 10 }, { a: Int -> a * 2 })
    println(composed2(2))
}

/**
 * Reference to a function
 */
fun isOdd(x: Int) = x % 2 != 0
// :: 연산자를 사용하면, 함수를 다른 함수에 값으로 전달할 수 있다.

/**
 * Composition of functions
 */
fun length(s: String) = s.length

// 이름 전에 angle brackets 를 이용하여 제네릭 함수로 이용할 수 있다.
fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

fun addTen(a: Int) = a + 10

fun mulTwo(a: Int) = a * 2

fun <T> compose2(fa: (T) -> T, fb: (T) -> T): (T) -> T {
    return { a -> fb(fa(a)) }
}