package exercises

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Chapter2Tests {
    @Nested
    class Exercise2_1Test {
        @Test
        fun shouldCalculateFib() {
            assertEquals(Exercise2_1.fib(10), 55)
        }
    }

    @Nested
    class Exercise2_2Tests {
        @Test
        fun shouldReturnTrue() {
            assertTrue(Exercise2_2.isSorted(listOf(1, 2, 3, 4)) { a, b -> a <= b })
            assertTrue(Exercise2_2.isSorted(listOf(1, 1, 1)) { a, b -> a <= b })
            assertTrue(Exercise2_2.isSorted(listOf(1)) { a, b -> a <= b })
            assertTrue(Exercise2_2.isSorted(emptyList<Int>()) { a, b -> a <= b })
        }

        @Test
        fun shouldReturnFalse() {
            assertFalse(Exercise2_2.isSorted(listOf(1, 2, 3, 4, 1)) { a, b -> a < b })
            assertFalse(Exercise2_2.isSorted(listOf(3, 2, 1)) { a, b -> a < b })
        }
    }

    @Nested
    class Exercise2_3Tests {
        @Test
        fun shouldCurry() {
            fun add(a: Int, b: Int): Int = a + b
            val curriedAdd = Exercise2_3.curry(::add)
            val result = curriedAdd(1)(2)
            assertEquals(result, 3)
        }
    }

    @Nested
    class Exercise2_4Tests {
        @Test
        fun shouldUncurry() {
            fun add(a: Int, b: Int): Int = a + b
            val curriedAdd = Exercise2_3.curry(::add)
            val uncurriedAdd = Exercise2_4.uncurry(curriedAdd)
            val result = uncurriedAdd(1, 2)
            assertEquals(result, 3)
        }
    }

    @Nested
    class Exercise2_5Tests {
        @Test
        fun shouldCompose() {
            fun add1(a: Int) =  a + 1
            fun sub1(a: Int) = a - 1
            val result = Exercise2_5.compose(::add1, ::sub1)(1)
            assertEquals(result, 1)
        }
    }
}
