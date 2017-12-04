object Day01 {

    fun sum(input: String): Int {
        var value = 0

        for (ind in 0 until input.length) {
            val curChar = input[ind]

            if (curChar == input[(ind + 1) % input.length]) {
                value += curChar.toString().toInt()
            }
        }

        return value
    }

    fun sum2(input: String): Int {
        var value = 0

        for (ind in 0 until input.length) {
            val curChar = input[ind]

            if (curChar == input[(ind + (input.length / 2)) % input.length]) {
                value += curChar.toString().toInt()
            }
        }

        return value
    }

    private fun inputToIntList(input: String) = input.map { Integer.valueOf(it.toString()) }

}