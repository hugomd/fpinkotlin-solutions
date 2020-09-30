package exercises

object Exercise2_1 {
    fun fib(i: Int): Int {
        tailrec fun go(n: Int, a: Int, b: Int): Int =
            when (n) {
                0 -> a
                else -> go(n = n - 1, a = a + b, b = a)
            }

        return go(i, 0, 1)
    }

    fun oldFib(i: Int): Int =
        when (i) {
            0 -> 0
            1 -> 1
            else -> oldFib(i - 1) + oldFib(
                i - 2
            )
        }
}

object Exercise2_2 {
    val <T> List<T>.tail: List<T>
        get() = drop(1)

    val <T> List<T>.head: T
        get() = first()

    fun <A> isSorted(aa: List<A>, ordered: (A, A) -> Boolean): Boolean {
        if (aa.isEmpty()) return true

        tailrec fun go(head: A, tail: List<A>): Boolean =
            when {
                tail.isEmpty() -> true
                ordered(head, tail.head) -> go(tail.head, tail.tail)
                else -> false
            }

        return go(aa.head, aa.tail)
    }
}

object Exercise2_3 {
    fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
        { a: A -> { b: B -> f(a, b) } }

}
object Exercise2_4 {
    fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
        { a: A, b: B -> f(a)(b) }
}

object Exercise2_5 {
    fun <A, B, C> compose(
        f: (B) -> C,
        g: (A) -> B
    ): (A) -> C = {a: A -> f(g(a))}
}