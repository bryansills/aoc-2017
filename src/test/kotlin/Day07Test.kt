import org.junit.Assert
import org.junit.Test

class Day07Test {

    @Test
    fun part1samples() {
        Assert.assertEquals("tknk", Day07.part1(getResourceAsString("day07sample01.txt")))
    }

    @Test
    fun part1() {
        Assert.assertEquals("xegshds", Day07.part1(getResourceAsString("day07.txt")))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(60, Day07.part2(getResourceAsString("day07sample01.txt")))
        Assert.assertEquals(66, Day07.part2(getResourceAsString("day07sample02.txt")))
        Assert.assertEquals(66, Day07.part2(getResourceAsString("day07sample03.txt")))
//        Assert.assertEquals(45, Day07.part2(getResourceAsString("day07sample04.txt")))
//        Assert.assertEquals(77, Day07.part2(getResourceAsString("day07sample05.txt")))
//        Assert.assertEquals(66, Day07.part2(getResourceAsString("day07sample06.txt")))
//        Assert.assertEquals(76, Day07.part2(getResourceAsString("day07sample07.txt")))
    }

    @Test
    fun part2() {
        Assert.assertEquals(299, Day07.part2(getResourceAsString("day07.txt")))
    }
}