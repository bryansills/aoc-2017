import org.junit.Assert
import org.junit.Test

class Day08Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(2, Day08.part1(getResourceAsString("day08sample01.txt")))
    }

    @Test
    fun part1() {
        Assert.assertEquals(6343, Day08.part1(getResourceAsString("day08.txt")))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(10, Day08.part2(getResourceAsString("day08sample01.txt")))
    }

    @Test
    fun part2() {
        Assert.assertEquals(7184, Day08.part2(getResourceAsString("day08.txt")))
    }
}