object Day04 {

    fun countValidPasswords(input: String): Int {
        val passwordList = input.split("\n")
        var result = 0

        for (password in passwordList) {
            val words = password.split("\\s+".toRegex())

            val set = words.toSet()

            if (words.size == set.size) {
                result++
            }
        }

        return result
    }

    fun countValidPasswords2(input: String): Int {
        val passwordList = input.split("\n")
        var result = 0

        for (password in passwordList) {
            val words = password.split("\\s+".toRegex())
            val set = mutableSetOf<Map<Char, Int>>()

            words.forEach { set.add(buildMap(it)) }

            if (words.size == set.size) {
                result++
            }
        }

        return result
    }

    private fun buildMap(word: String): Map<Char, Int> {
        var result = HashMap<Char, Int>()

        word.forEach {
            if (result.containsKey(it)) {
                result.put(it, result.getValue(it) + 1)
            } else {
                result.put(it, 1)
            }
        }

        return result
    }
}