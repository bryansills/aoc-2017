import org.junit.Assert
import org.junit.Test

class Day03Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(0, Day03.steps(1))
        Assert.assertEquals(3, Day03.steps(12))
        Assert.assertEquals(2, Day03.steps(23))
        Assert.assertEquals(6, Day03.steps(49))
        Assert.assertEquals(31, Day03.steps(1024))
    }

    @Test
    fun part1() {
        Assert.assertEquals(419, Day03.steps(289326))
    }

    @Test
    fun part2samples() {
    }

    @Test
    fun part2() {
    }
}