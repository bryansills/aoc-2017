import org.junit.Assert
import org.junit.Test

class Day06Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(5, Day06.part1("0 2 7 0"))
        Assert.assertEquals(1, Day06.part1("0 0 0 0"))
        Assert.assertEquals(4, Day06.part1("1 0 0 0"))
    }

    @Test
    fun part1() {
        Assert.assertEquals(11137, Day06.part1("14	0	15	12	11	11	3	5	1	6	8	4	9	1	8	4"))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals(4, Day06.part2("0 2 7 0"))
        Assert.assertEquals(1, Day06.part2("0 0 0 0"))
        Assert.assertEquals(4, Day06.part2("1 0 0 0"))
    }

    @Test
    fun part2() {
        Assert.assertEquals(1037, Day06.part2("14	0	15	12	11	11	3	5	1	6	8	4	9	1	8	4"))
    }
}