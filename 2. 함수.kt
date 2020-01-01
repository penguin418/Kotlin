fun joinOptions(options: Collection<String>) =
        "["+options.joinToString(separator = ", ")+"]"
/*  함수
*   함수 선언
* kotlin 에서 함수는 fun 키워드로 선언된다
* fun double(x: Int): Int {
*     return 2 * x
* }
*
*   함수 사용
* 함수 호출은 전통적인 접근방법을 따른다
* val result = double(2)
* 멤버 함수를 부르는 것은 . 을 사용한다
* Stream().read() // 스트림 인스턴스를 생성하고, 그 인스턴스의 read()를 호출
*
*
*   매개변수(parameter)
* 함수 파라미터는 pascal 표기를 따르며 타입을 명시해야한다 , 로 구별된다
* fun powerOf(number: Int, exponent: Int) { ... }
*
*   기본 인자(Default Argument)
* 함수 호출 시 인자를 기입하지 않는 경우, 매개변수는 기본 값을 가질 수 있다
* = 연산자를 사용하여 기본 인자를 표현한다
* fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) { ... }
* 오버로딩을 사용하면 매개변수는 동일한 기본 값을 가져야 하며 이를 지키기 위해 오버로딩 함수에선
* 기본 인자를 명시하지 않는다
* open class A {
*     open fun foo(i: Int = 10) { ... }
* }
* class B : A() {
*     override fun foo(i: Int) { ... }  // 오버로딩 함수는 기본 인자를 명시하면 안된다
* }
* 값을 넘겨주지 않으면 기본 값이 사용된다
* fun foo(bar: Int = 0, baz: Int) { ... }
* 네임드 인자(named argument, 파이썬의 키워드 인자와 유사)를 사용하면 선행 인자를 비운 상태로 호출 할 수 있다
* foo(baz = 1) // bar 에는 기본 값인 0이 사용된다
* 기본 인자 이후 마지막 인자가 lambda 인 경우, 네임드 인자 혹은 괄호 밖에 넣어줄 수 있다
* fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { ... }
*
* foo(qux = { println("hello") }) // bar, baz 에 모두 기본 값이 사용되었고, qux 를 명시하여 네임드 인자를 사용했다
* foo(1) { println("hello") }     // baz 에만 기본값이 사용되었고, bar 는 인자를 표기, lambda 는 괄호 밖에 표기하였다
* foo { println("hello") }        // lambda 를 괄호 밖에 표기하였다
* 추가 [람다][https://kotlinlang.org/docs/reference/lambdas.html#lambda-expression-syntax]
*
*   네임드 인자(named argument)
* 매개변수는 이름을 명시하여(네임드) 넘겨줄 수 있다
* fun reformat(str: String,
*              normalizeCase: Boolean = true,
*              upperCaseFirstLetter: Boolean = true,
*              divideByCamelHumps: Boolean = false,
*              wordSeparator: Char = ' ') {...}
* 위의 함수를 아래처럼 표현하면 너무 기므로
* reformat(str, true, true, false, '_')
* named 하여 사용하면 필요한 인자만 명시하여 표현해도 된다
* reformat(str, wordSeparator = '_')
* 가변인자는 spread 연산자를 사용하여 표시할 수 있다
* fun foo(vararg strings: String) { ... }
*
* foo(strings = *arrayOf("a", "b", "c"))
* 네임드 인자는 jvm 내에서 자바 함수를 호출할 때 사용할 수 없다
*
*   Unit 반환 함수
* 함수가 값을 반환하지 않는 경우 반환형은 Unit 이 되며, 이 함수는 명시적으로 return 을 표기하지 않아도 된다
* fun printHello(name: String?): Unit {
*     if (name != null)
*         println("Hello ${name}")
*     else
*         println("Hi there!")
*     // `return Unit` or `return` is optional
* }
* Unit 반환형은 생략해도 된다
* fun printHello(name: String?) { ... }
*
*   단일-expression 함수
* 단일 표현 함수의 경우 중괄호를 생략하고 =으로 대체할 수 있다
* fun double(x: Int): Int = x * 2
* 이 경우 반환형도 생략할 수 있다(컴파일러가 추론한다)
* fun double(x: Int) = x * 2
*
*   명시적 반환 타입
* 바디 블록이 있는 함수는 항상 리턴 타입을 명시해야 한다
* 그렇지 않으면 Unit 반환으로 추론된다
*
*   가변 인자
* 매개변수(마지막 인자)에 가변인자를 삽입할 수 있다
* fun <T> asList(vararg ts: T): List<T> {
*     val result = ArrayList<T>()
*     for (t in ts) // ts is an Array
*         result.add(t)
*     return result
* }
* 가변 인자는 다수의 인자를 함수에 넘겨주는 것을 허용한다
* val list = asList(1, 2, 3)
* T 타입에 관한 vararg 매개변수는 사실 Array<out of T> 로 표현된다
* 함수 매개변수 중 단 하나만이 가변인자가 될 수 있다
* 가변인자가 함수의 마지막 매개변수가 아니라면 반드시 named 인자로 호출하여야 한다
* 가변 인자에 여러 값을 넘기려면 *를 배열의 접두어로 쓰는 spread 연산자를 사용하면 된다 (a 참조)
* val a = arrayOf(1, 2, 3)
* val list = asList(-1, 0, *a, 4)
*
*   Infix 표기
* infix 가 표기된 함수는 . 을 이용해서(혹은 생략해서) 호출 할 수 있다
* infix 함수는 다음의 조건을 만족하여야 한다
*   멤버 함수이거나, extension 함수여야 한다
*   단 하나의 매개변수만을 가져야 한다
*   매개변수는 가변인자를 받거나 기본 값이 있어서는 안된다
* infix fun Int.shl(x: Int): Int { ... }
*
* // inflix 표기를 이용한 호출
* 1 shl 2
*
* // 아래도 같은 의미이다
* 1.shl(2)
* inflix 표기는 산술 연산자보다 우선 순위가 낮다
* 그러므로 다음의 표기는 같은 의미이다
*   1 shl 2 + 3           is equivalent to  1 shl (2 + 3)
*   0 until n * 2         is equivalent to  0 until (n * 2)
*   xs union ys as Set<*> is equivalent to  xs union (ys as Set<*>)
* 하지만 boolean 연산자인 &&, ||, is-and, in-checks 등 보다는 우선 순위가 높다
* 그러므로 다음의 표기는 같은 의미이다
*   a && b xor c          is equivalent to  a && (b xor c)
*   a xor b in c          is equivalent to  (a xor b) in c
* 추가 [문법][https://kotlinlang.org/docs/reference/grammar.html#expressions]
* inflix 함수의 각 부분은 다음의 명칭을 가진다
* inflix fun dispatcher.함수 이름(receiver)
* 클래스 내부에 정의할 때는 dispatcher 를 생략하여도 된다
* 호출할 때는 this 를 사용하여 disptacher 가 현재 객체임을 명시할 수 있다
* class MyStringCollection {
*     infix fun add(s: String) { ... }
*
*     fun build() {
*         this add "abc"   // Correct
*         add("abc")       // Correct
*         add "abc"        // Incorrect: dispatcher 가 없으면 receiver 는 반드시 명시되어야 한다
*     }
* }
*
*   함수 스코프
* 코틀린 함수는 파일의 탑 레벨에 생성될 수 있다 이것은 함수를 생성할 때 클래스를 반드시 생성할 필요가 없다는 의미이다
*
* 지역 함수 - 함수 내부에 함수를 선언할 수 있다
* fun dfs(graph: Graph) {
*     fun dfs(current: Vertex, visited: MutableSet<Vertex>) {
*         if (!visited.add(current)) return
*         for (v in current.neighbors)
*             dfs(v, visited)
*     }
*
*     dfs(graph.vertices[0], HashSet())
* }
* 지역 함수는 클로져 등의 외부 함수가 가진 지역 변수에 접근할 수 있다
* fun dfs(graph: Graph) {
*     val visited = HashSet<Vertex>()
*     fun dfs(current: Vertex) {
*         if (!visited.add(current)) return
*         for (v in current.neighbors)
*             dfs(v)
*     }
*
*     dfs(graph.vertices[0])
* }
* 멤버 함수 - 클래스, 객체 내에 생성할 수 있다
* class Sample() {
*     fun foo() { print("Foo") }
* }
* 멤버 함수는 . 을 이용해 호출될 수 있다
* Sample().foo() // creates instance of class Sample and calls foo
* 참고 [클래스][https://kotlinlang.org/docs/reference/classes.html]
* 참고 [상속][https://kotlinlang.org/docs/reference/classes.html#inheritance]
* 제네릭 함수 - 제네릭 매개변수는 <> 를 이용해 사용한다
* fun <T> singletonList(item: T): List<T> { ... }
* 참고 [제네릭][https://kotlinlang.org/docs/reference/generics.html]
* 참고 [인라인 함수][https://kotlinlang.org/docs/reference/inline-functions.html]
* 참고 [extension 함수][https://kotlinlang.org/docs/reference/extensions.html]
* 참고 [high-order 함수 및 람다][https://kotlinlang.org/docs/reference/lambdas.html]
* 재귀 함수(꼬리 재귀 함수)
* 참고 [tail recursive][https://en.wikipedia.org/wiki/Tail_call]
* tailrec 수식어를 통해 정의할 수 있으며 요구되는 폼이 있다(stack overflow 의 위협이 있다)
* val eps = 1E-10 // "good enough", could be 10^-15
*
* tailrec fun findFixPoint(x: Double = 1.0): Double
*         = if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))
* 다음의 코드는 연산 결과가 바뀌지 않을 때 까지 코사인의 fixpoint 를 계산한다. 
* val eps = 1E-10 // "good enough", could be 10^-15
*
* private fun findFixPoint(): Double {
*     var x = 1.0
*     while (true) {
*         val y = Math.cos(x)
*         if (Math.abs(x - y) < eps) return x
*         x = Math.cos(x)
*     }
* }
* 추가적인 로직이 더 필요한 경우, 사용이 힘들다
* tailrec 함수에는 try/catch/final 블록을 사용할 수 없다
* 현재는 jvm 과 kotlin/native 에서 지원된다
*/
