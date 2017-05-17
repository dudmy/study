package example

/**
 * Created by yujin on 2017. 4. 1..
 */
fun main(args: Array<String>) {

    println("--Destructuring declarations--")
    val pair = Pair(1, "one")
    val (num, desc) = pair
    println("num = $num, desc = $desc")

    println("\n--Data classes--")
    val user = getUser()
    println("name = ${user.name}, id = ${user.id}")
    val (name, id) = getUser()
    println("name = $name, id = $id")
    println("name = ${getUser().component1()}, id = ${getUser().component2()}")

    println("\n--Auto generated functions--")
    autoGenFunctions()

    println("\n--Traversing a map--")
    traversingMap()
}

/**
 * Destructuring declarations
 * 한번에 여러 변수를 선언할 수 있고 독립적으로 사용 가능하다.
 * http://kotlinlang.org/docs/reference/multi-declarations.html#multi-declarations
 */
class Pair<K, V>(val first: K, val second: V) {
    // 분리 선언을 사용하기 위해서는 componentN() 함수에 operator 키워드가 필요하다.
    // componentN()은 for-loop, +, - 와 같이 코틀린의 principle of conventions 을 적용한 예이다.
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

/**
 * Data classes
 * 데이터만 가지고 다른 기능을 하지 않는 클레스를 정의한다.
 * http://kotlinlang.org/docs/reference/data-classes.html#data-classes
 */
data class User(val name: String, val id: Int)

fun getUser(): User {
    return User("Alex", 1)
}

/**
 * Auto generated functions
 */
fun autoGenFunctions() {
    val user = User("Alex", 1)
    println(user) // toString()

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)
    println("user == secondUser: ${user == secondUser}") // 값을 비교
    println("user == thirdUser: ${user == thirdUser}")

    // 객체를 복사할 때 일부 프로퍼티만 변경하고 싶은 경우에 copy()를 이용한다.
    println(user.copy())
    println(user.copy("Max"))
    println(user.copy(id = 2))
    println(user.copy("Max", 2))
}

/**
 * Traversing a map
 */
fun traversingMap() {
    val map = hashMapOf<String, Int>()
    map.put("one", 1)
    map.put("two", 2)

    for ((key, value) in map) {
        println("key = $key, value = $value")
    }
}