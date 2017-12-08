import utils.splitWhitespace
import utils.toIntList
import kotlin.coroutines.experimental.buildSequence

object Day06 {

    fun part1(input: String): Int {
        var intList = input.splitWhitespace().toIntList()

        var banks = intList
        var step = 0
        var prevBanks = mutableListOf<List<Int>>()

        var newBanks = banks.toIntArray()
        while (!prevBanks.contains(newBanks.asList())) {
            prevBanks.add(newBanks.toList())

            var maxIndex = newBanks.indexOf(newBanks.max() ?: throw IllegalStateException("no vals?"))
            var maxValue = newBanks[maxIndex]
            newBanks[maxIndex] = 0

            var redistIndex = (maxIndex + 1) % newBanks.size
            while (maxValue > 0) {
                newBanks[redistIndex] += 1
                redistIndex = (redistIndex + 1) % newBanks.size
                maxValue--
            }

            step++
        }

        return step
    }

    fun part2(input: String): Int {
        var intList = input.splitWhitespace().toIntList()

        var banks = intList
        var step = 0
        var prevBanks = mutableListOf<List<Int>>()

        var newBanks = banks.toIntArray()
        while (!prevBanks.contains(newBanks.asList())) {
            prevBanks.add(newBanks.toList())

            var maxIndex = newBanks.indexOf(newBanks.max() ?: throw IllegalStateException("no vals?"))
            var maxValue = newBanks[maxIndex]
            newBanks[maxIndex] = 0

            var redistIndex = (maxIndex + 1) % newBanks.size
            while (maxValue > 0) {
                newBanks[redistIndex] += 1
                redistIndex = (redistIndex + 1) % newBanks.size
                maxValue--
            }

            step++
        }

        var prevIndex = prevBanks.indexOf(newBanks.asList())

        return step - prevIndex
    }
}