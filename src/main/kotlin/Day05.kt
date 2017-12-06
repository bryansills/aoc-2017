import utils.splitNewlines
import utils.toIntList
import kotlin.coroutines.experimental.buildSequence

object Day05 {

    fun part1(input: String): Int {
        var intList = input.splitNewlines().toIntList().toIntArray()

        val stepList = buildSequence {
            var offsets = intList
            var step = 0
            var index = 0

            while (index >= 0 && index < offsets.size) {
                yield(State(step, index, offsets.asList()))

                val jump = offsets[index]
                offsets[index] = offsets[index] + 1

                index += jump
                step++
            }

            yield(State(step, index, offsets.asList()))
        }

        return stepList.last().step
    }

    fun part2(input: String): Int {
        var intList = input.splitNewlines().toIntList().toIntArray()

        val stepList = buildSequence {
            var offsets = intList
            var step = 0
            var index = 0

            while (index >= 0 && index < offsets.size) {
                yield(State(step, index, offsets.asList()))

                val jump = offsets[index]

                if (offsets[index] >= 3) {
                    offsets[index] = offsets[index] - 1
                } else {
                    offsets[index] = offsets[index] + 1
                }

                index += jump
                step++
            }

            yield(State(step, index, offsets.asList()))
        }

        return stepList.last().step
    }
}

data class State (val step: Int, val index: Int, val offsets: List<Int>)