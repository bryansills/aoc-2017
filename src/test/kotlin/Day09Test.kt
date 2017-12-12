import org.junit.Assert
import org.junit.Test

class Day09Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(1, Day09.part1("{}"))
        Assert.assertEquals(6, Day09.part1("{{{}}}"))
        Assert.assertEquals(5, Day09.part1("{{},{}}"))
        Assert.assertEquals(16, Day09.part1("{{{},{},{{}}}}"))
        Assert.assertEquals(1, Day09.part1("{<a>,<a>,<a>,<a>}"))
        Assert.assertEquals(9, Day09.part1("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
        Assert.assertEquals(9, Day09.part1("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
        Assert.assertEquals(3, Day09.part1("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
    }

    @Test
    fun part1() {
        Assert.assertEquals(23588, Day09.part1(getResourceAsString("day09.txt")))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(0, Day09.part2("<>"))
        Assert.assertEquals(17, Day09.part2("<random characters>"))
        Assert.assertEquals(3, Day09.part2("<<<<>"))
        Assert.assertEquals(2, Day09.part2("<{!>}>"))
        Assert.assertEquals(0, Day09.part2("<!!>"))
        Assert.assertEquals(0, Day09.part2("<!!!>>"))
        Assert.assertEquals(10, Day09.part2("<{ori!a,<{i<a>"))
    }

    @Test
    fun part2() {
        Assert.assertEquals(10045, Day09.part2(getResourceAsString("day09.txt")))
    }
}