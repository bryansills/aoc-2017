
import utils.splitCommas
import kotlin.math.abs
import kotlin.math.max

object Day11 {

    // Using cube coordinates
    fun part1(input: String): Int {
        val path = input.splitCommas()

        var x = 0
        var y = 0
        var z = 0

        path.forEach {
            when (it) {
                "n" -> {
                    y++
                    z--
                }
                "ne" -> {
                    x++
                    z--
                }
                "se" -> {
                    x++
                    y--
                }
                "s" -> {
                    y--
                    z++
                }
                "sw" -> {
                    x--
                    z++
                }
                "nw" -> {
                    x--
                    y++
                }
            }
        }

        return (abs(x) + abs(y) + abs(z)) / 2
    }

    // Using cube coordinates
    fun part2(input: String): Int {
        val path = input.splitCommas()

        var x = 0
        var y = 0
        var z = 0

        var furthestDistance = 0

        path.forEach {
            when (it) {
                "n" -> {
                    y++
                    z--
                }
                "ne" -> {
                    x++
                    z--
                }
                "se" -> {
                    x++
                    y--
                }
                "s" -> {
                    y--
                    z++
                }
                "sw" -> {
                    x--
                    z++
                }
                "nw" -> {
                    x--
                    y++
                }
            }

            furthestDistance = max(furthestDistance, calcDistance(x, y, z))
        }

        return furthestDistance
    }

    private fun calcDistance(x: Int, y: Int, z: Int): Int {
        return (abs(x) + abs(y) + abs(z)) / 2
    }
}