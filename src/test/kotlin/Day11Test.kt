import org.junit.Assert
import org.junit.Test

class Day11Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(3, Day11.part1("ne,ne,ne"))
        Assert.assertEquals(0, Day11.part1("ne,ne,sw,sw"))
        Assert.assertEquals(2, Day11.part1("ne,ne,s,s"))
        Assert.assertEquals(3, Day11.part1("se,sw,se,sw,sw"))
    }

    @Test
    fun part1() {
        Assert.assertEquals(877, Day11.part1(getResourceAsString("day11.txt")))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(3, Day11.part2("ne,ne,ne"))
        Assert.assertEquals(2, Day11.part2("ne,ne,sw,sw"))
        Assert.assertEquals(2, Day11.part2("ne,ne,s,s"))
        Assert.assertEquals(3, Day11.part2("se,se,se,sw,nw"))
    }

    @Test
    fun part2() {
        Assert.assertEquals(1622, Day11.part2(getResourceAsString("day11.txt")))
    }
}