package example

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by yujin on 2017. 4. 2..
 */
fun main(args: Array<String>) {

    println("--Custom delegate--")
    val e = CustomExample()
    println(e.p)
    e.p = "NEW"

    println("\n--Lazy property--")
    val sample = LazySample()
    println("lazy = ${sample.lazy}")
    println("lazy = ${sample.lazy}")

    println("\n--Observable property--")
    val user1 = User1()
    user1.name = "Carl"

    println("\n--NotNull property--")
    val user2 = User2()
    // println(userNo.name) -> IllegalStateException
    user2.init("Mark")
    println(user2.name)

    println("\n--Properties in map--")
    val user3 = User3(mapOf(
            "name" to "John Doe",
            "age" to 25
    ))
    println("name = ${user3.name}, age = ${user3.age}")
}

/**
 * Custom delegate
 */
class CustomExample {
    // 위임 프로퍼티 구문: val/var <property name>: <Type> by <expression>
    var p: String by Delegate()

    override fun toString() = "example.CustomExample Class"
}

class Delegate {
    // 프로퍼티에 대한 get()을 위임한다.
    // 파라미터1: p를 포함한 객체, 파라미터2: p 자체에 대한 설명을 포함?
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    // 프로퍼티에 대한 set()을 위임한다.
    // 파라미터1: p를 포함한 객체, 파라미터2: p 자체에 대한 설명을 포함?, 파라미터3: 새로 설정하는 값
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to '${prop.name}' in $thisRef")
    }
}

/**
 * Lazy property
 */
class LazySample {
    // 람다를 파라미터로 받고 lazy 프로퍼티를 구현하기 위한 위임 객체인 Lazy<T> 인스턴스를 리턴한다.
    // Thread safety 를 원하는 경우 blockingLazy()를 이용해야한다.
    val lazy: String by lazy {
        println("computed!")
        "my lazy"
    }
}

/**
 * Observable property
 */
class User1 {
    // 초기값과 수정에 대한 핸들러를 인자로 갖으며, 프로퍼티에 값을 할당할 때마다 핸드러를 호출한다.
    var name: String by Delegates.observable("no name") {
        d, old, new ->
        println("${d.returnType} - $old -> $new")
    }
}

/**
 * NotNull property
 */
class User2 {
    // 프로퍼티를 writing 하기 전에 read 를 하려고 하는 경우 exception 을 던진다.
    var name: String by Delegates.notNull()

    fun init(name: String) {
        this.name = name
    }
}

/**
 * Properties in map
 */
class User3(val map: Map<String, Any?>) {
    // 프로퍼티의 값을 맵에 저장하는 작업을 위임 프로퍼티로 맵 인스턴스 자체를 사용한다.
    val name: String by map
    val age: Int by map
}