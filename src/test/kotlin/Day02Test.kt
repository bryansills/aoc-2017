import org.junit.Assert
import org.junit.Test

class Day02Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(8, Day02.checksum("5 1 9 5"))
        Assert.assertEquals(4, Day02.checksum("7 5 3"))
        Assert.assertEquals(6, Day02.checksum("2 4 6 8"))
        Assert.assertEquals(18, Day02.checksum(getResourceAsString("day02sample01.txt")))
    }

    @Test
    fun part1() {
        Assert.assertEquals(37923, Day02.checksum(getResourceAsString("day02.txt")))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(4, Day02.evenlyDivisibleSum("5 9 2 8"))
        Assert.assertEquals(3, Day02.evenlyDivisibleSum("9 4 7 3"))
        Assert.assertEquals(2, Day02.evenlyDivisibleSum("3 8 6 5"))
        Assert.assertEquals(9, Day02.evenlyDivisibleSum(getResourceAsString("day02sample02.txt")))
    }

    @Test
    fun part2() {
        Assert.assertEquals(263, Day02.evenlyDivisibleSum(getResourceAsString("day02.txt")))
    }
}