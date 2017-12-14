
import utils.splitCommas
import utils.toIntList

object Day10 {

    fun part1(list: MutableList<Int>, input: String): Int {
        val steps = input.splitCommas().toIntList()
        var skip = 0
        var index = 0

        steps.forEach {
            reverse(list, index, it)
            index = (index + it + skip) % list.size
            skip++
        }

        return list[0] * list[1]
    }

    val APPENDS = listOf(17, 31, 73, 47, 23)

    fun part2(input: String): String {
        val steps = input.toAsciiList()
        steps.addAll(APPENDS)

        val loop = (0..255).toMutableList()
        var skip = 0
        var index = 0

        for (round in 1..64) {
            steps.forEach {
                reverse(loop, index, it)
                index = (index + it + skip) % loop.size
                skip++
            }
        }

        val denseHash = mutableListOf<Int>()
        for (inner in 0 until 16) {
            var block = 0
            for (outer in 0 until 16) {
                val element = loop[(inner * 16) + outer]
                block = block.xor(element)
            }
            denseHash.add(block)
        }

        var result = ""
        denseHash.forEach {
            result += it.toString(16).padStart(2, '0')
        }

        return result
    }

    private fun reverse(list: MutableList<Int>, start: Int, length: Int) {
        val halfway = length / 2

        for (index in 0 until halfway) {
            val leftIndex = (start + index) % list.size
            val rightIndex = (start + length - index - 1) % list.size

            val left = list[leftIndex]
            val right = list[rightIndex]

            list[leftIndex] = right
            list[rightIndex] = left
        }
    }

    private fun String.toAsciiList(): MutableList<Int> {
        return this.map {
            it.toInt()
        }.toMutableList()
    }
}