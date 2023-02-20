package leetcode

class FizzBuzz {
    /**
     * when cases have specific order - time optimization - higher is more frequency
     * for n = 25 =>
     * Number    : 13
     * Fizz      : 6
     * Buzz      : 3
     * FizzBuzz  : 2
     */
    fun fizzBuzz(n: Int): List<String> {
        val rsl = ArrayList<String>()
        for (index in 1..n) {
            val div3 = index % 3 == 0
            val div5 = index % 5 == 0
            rsl += when {
                !div3 && !div5 -> index.toString()
                div3 && !div5 -> "Fizz"
                !div3 && div5 -> "Buzz"
                else -> "FizzBuzz"
            }
        }
        return rsl
    }
}