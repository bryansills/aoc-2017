object Day02 {

    fun checksum(input: String): Int {
        var result = 0

        val lines = input.split("\n")
        for (line in lines) {

            val digits = line.split("\\s+".toRegex())

            var minVal = Int.MAX_VALUE
            var maxVal = Int.MIN_VALUE

            for (digitStr in digits) {
                val digit = digitStr.toInt()

                if (digit < minVal) {
                    minVal = digit
                }
                if (digit > maxVal) {
                    maxVal = digit
                }
            }

            result += (maxVal - minVal)
        }

        return result
    }

    fun evenlyDivisibleSum(input: String): Int {
        var result = 0

        val lines = input.split("\n")
        for (line in lines) {

            val digits = line.split("\\s+".toRegex())

            for (ii in 0 until digits.size) {
                for (jj in 0 until digits.size) {
                    val left = digits[ii].toInt()
                    val right = digits[jj].toInt()

                    if (ii != jj && left % right == 0) {
                        result += (left / right)
                    }
                }
            }
        }

        return result
    }
}