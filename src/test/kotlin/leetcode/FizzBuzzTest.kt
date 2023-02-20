package leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 *
 * 3  - [1, 2, Fizz]
 * 5  - [1, 2, Fizz, 4, Buzz]
 * 15 - [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
 * 25 - [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz]
 */
internal class FizzBuzzTest {
    private val obj = FizzBuzz()
    private val for3 = listOf("1", "2", "Fizz")
    private val for5 = for3.copyAndAdd("4", "Buzz")
    private val for15 = for5.copyAndAdd("Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz")
    private val for25 = for15.copyAndAdd("16", "17", "Fizz", "19", "Buzz", "Fizz", "22", "23", "Fizz", "Buzz")

    @Test fun `fizzBuzz for 3`() = assertEquals(for3, obj.fizzBuzz(3))
    @Test fun `fizzBuzz for 5`() = assertEquals(for5, obj.fizzBuzz(5))
    @Test fun `fizzBuzz for 15`() = assertEquals(for15, obj.fizzBuzz(15))
    @Test fun `fizzBuzz for 25`() = assertEquals(for25, obj.fizzBuzz(25))

    private fun <T> List<T>.copyAndAdd(vararg elements: T): MutableList<T> {
        return this.toMutableList().apply { for (e in elements) this.add(e) }
    }
}
