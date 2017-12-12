object Day09 {

    fun part1(input: String): Int {
        var result = 0
        var groupLevel = 0
        var garbage = false
        var ignore = false

        input.forEach { char ->
            if (garbage) {
                if (ignore) {
                    ignore = false
                } else {
                    when (char) {
                        '>' -> {
                            garbage = false
                        }
                        '!' -> {
                            ignore = true
                        }
                    }
                }
            } else {
                when (char) {
                    '{' -> {
                        groupLevel++
                    }
                    '}' -> {
                        result += groupLevel
                        groupLevel--
                    }
                    '<' -> {
                        garbage = true
                    }
                }
            }
        }

        return result
    }

    fun part2(input: String): Int {
        var result = 0
        var garbage = false
        var ignore = false

        input.forEach { char ->
            if (garbage) {
                if (ignore) {
                    ignore = false
                } else {
                    when (char) {
                        '>' -> {
                            garbage = false
                        }
                        '!' -> {
                            ignore = true
                        }
                        else -> {
                            result++
                        }
                    }
                }
            } else {
                when (char) {
                    '<' -> {
                        garbage = true
                    }
                }
            }
        }

        return result
    }
}