import org.junit.Assert
import org.junit.Test

class Day05Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(5, Day05.part1("0\n3\n0\n1\n-3"))
        Assert.assertEquals(6, Day05.part1("0\n0\n0"))
        Assert.assertEquals(1, Day05.part1("-1"))
    }

    @Test
    fun part1() {
        Assert.assertEquals(396086, Day05.part1(getResourceAsString("day05.txt")))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(10, Day05.part2("0\n3\n0\n1\n-3"))
    }

    @Test
    fun part2() {
        Assert.assertEquals(28675390, Day05.part2(getResourceAsString("day05.txt")))
    }
}