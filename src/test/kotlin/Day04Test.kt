import org.junit.Assert
import org.junit.Test

class Day04Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(1, Day04.countValidPasswords("aa bb cc dd ee"))
        Assert.assertEquals(0, Day04.countValidPasswords("aa bb cc dd aa"))
        Assert.assertEquals(1, Day04.countValidPasswords("aa bb cc dd aaa"))
    }

    @Test
    fun part1() {
        Assert.assertEquals(477, Day04.countValidPasswords(getResourceAsString("day04.txt")))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(1, Day04.countValidPasswords2("abcde fghij"))
        Assert.assertEquals(0, Day04.countValidPasswords2("abcde xyz ecdab"))
        Assert.assertEquals(1, Day04.countValidPasswords2("a ab abc abd abf abj"))
        Assert.assertEquals(1, Day04.countValidPasswords2("iiii oiii ooii oooi oooo"))
        Assert.assertEquals(0, Day04.countValidPasswords2("oiii ioii iioi iiio"))
    }

    @Test
    fun part2() {
        Assert.assertEquals(167, Day04.countValidPasswords2(getResourceAsString("day04.txt")))
    }
}