package example

/**
 * Created by yujin on 2017. 3. 29..
 */
fun main(args: Array<String>) {
    // 자바는 모든 함수가 클래스에 속해있어야 하는데 코틀린은 안그렇다.
    // 코틀린은 메서드만으로 구성할 수 있고 파일명을 기준으로 자동으로 클래스가 생성되고 static 메서드가 만들어진다.
    // 자세한 내용은 https://realm.io/kr/news/kotlin-2/ 의 '객체 없는 함수'를 살펴보자.
    println("Hello Kotlin!")

    example1(args)
    example2(args)
    example3(args)
    example4(args)
}

/**
 * Reading a name from the command line
 */
fun example1(args: Array<String>) {
    if (args.isEmpty()) {
        println("Please provide a name as a command-line argument")
        return
    }
    // 배열과 같이 index 지정이 필요한 경우에는 대괄호({})로 감싸주어야 한다.
    println("example.example1: Hello, ${args[0]}!")
}

/**
 * Reading many names from the command line
 */
fun example2(args: Array<String>) {
    for (name in args)
        println("example.example2: Hello, $name!")
    // 일반적인 변수는 대괄호 없이 출력할 수 있다.
}

/**
 * A multi-language Hello
 */
fun example3(args: Array<String>) {
    val language = if (args.isEmpty()) "EN" else args[1]
    println("example.example3: " +
            when (language) {
                "EN" -> "Hello!"
                "FR" -> "Salut!"
                "IT" -> "Ciao!"
                else -> "Sorry, I can't greet you in $language yet"
    })
    // 출력함수 내부에 분기문을 넣을 수가 있다. 신기...
}

/**
 * An object-oriented Hello
 */
fun example4(args: Array<String>) {
    Greeter(args[2]).greet()
    // 클래스 생성과 동시에 내부 함수 호출이 가능한건가?
    // 이 부분은 앞으로 문법을 조금 더 살펴봐야 이해가 갈 것 같다.
}
class Greeter(val name: String) {
    fun greet() {
        println("example.example4: Hello, $name")
    }
}