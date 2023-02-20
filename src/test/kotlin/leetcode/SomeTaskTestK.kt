package leetcode

import org.junit.jupiter.api.Test

/**
 * run configuration:
 * pattern :
 *     leetcode.ZigZagIteratorTestK$ZigZagIterator_DaniilsV1
 *     ||leetcode.ZigZagIteratorTestK$ZigZagIterator_DaniilsV2
 */
interface SomeTaskTestK {
    @Test fun `default`() = println("privet")

    class ZigZagIterator_DaniilsV1 : SomeTaskTestK {
        @Test fun `run`() = println("privet ZigZagIterator_DaniilsV1")
    }

    class ZigZagIterator_DaniilsV2 : SomeTaskTestK {
        @Test fun `run_V2`() = println("privet ZigZagIterator_DaniilsV2")
    }
    class ZigZagIterator_DaniilsV3 : SomeTaskTestK {
        @Test fun `run_V3`() = println("privet ZigZagIterator_DaniilsV3")
    }
}