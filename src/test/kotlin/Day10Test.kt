import org.junit.Assert
import org.junit.Test

class Day10Test {

    @Test
    fun part1samples() {
        Assert.assertEquals(12, Day10.part1((0..4).toMutableList(), "3,4,1,5"))
    }

    @Test
    fun part1() {
        Assert.assertEquals(6952, Day10.part1((0..255).toMutableList(), "31,2,85,1,80,109,35,63,98,255,0,13,105,254,128,33"))
    }

    @Test
    fun part2samples() {
        Assert.assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10.part2(""))
        Assert.assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10.part2("AoC 2017"))
        Assert.assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10.part2("1,2,3"))
        Assert.assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Day10.part2("1,2,4"))
    }

    @Test
    fun part2() {
        Assert.assertEquals("28e7c4360520718a5dc811d3942cf1fd", Day10.part2("31,2,85,1,80,109,35,63,98,255,0,13,105,254,128,33"))
    }
}