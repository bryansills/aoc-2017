import utils.splitNewlines
import utils.splitWhitespace

object Day08 {

    val GREATER_THAN = ">"
    val LESS_THAN = "<"
    val GREATER_THAN_OR_EQUAL = ">="
    val LESS_THAN_OR_EQUAL = "<="
    val EQUAL = "=="
    val NOT_EQUAL = "!="

    val INC = "inc"
    val DEC = "dec"

    fun part1(input: String): Int {
        val splitInput = input.splitNewlines().map { it.splitWhitespace() }

        val registers = mutableMapOf<String, Int>().withDefault { 0 }
        splitInput.forEach {
            processInstruction(registers, it)
        }

        return registers.values.max() ?: -1
    }

    fun part2(input: String): Int {
        val splitInput = input.splitNewlines().map { it.splitWhitespace() }

        val registers = mutableMapOf<String, Int>().withDefault { 0 }
        var maxReg = 0
        splitInput.forEach {
            processInstruction(registers, it)

            if (maxReg < registers.values.max() ?: -1) {
                maxReg = registers.values.max() ?: -1
            }
        }

        return maxReg
    }

    private fun processInstruction(registers: MutableMap<String, Int>, instruction: List<String>) {
        val condRegister = instruction[4]
        val condComparator = instruction[5]
        val condValue = instruction[6].toInt()

        val condRegisterValue = registers[condRegister] ?: 0
        val result = when (condComparator) {
            GREATER_THAN -> condRegisterValue > condValue
            LESS_THAN -> condRegisterValue < condValue
            GREATER_THAN_OR_EQUAL -> condRegisterValue >= condValue
            LESS_THAN_OR_EQUAL -> condRegisterValue <= condValue
            EQUAL -> condRegisterValue == condValue
            NOT_EQUAL -> condRegisterValue != condValue
            else -> false
        }

        if (result) {
            val modRegister = instruction[0]
            val increase = instruction[1] == INC
            val amount = instruction[2].toInt()

            val modRegisterValue = registers[modRegister] ?: 0
            if (increase) {
               registers.put(modRegister, modRegisterValue + amount)
            } else {
                registers.put(modRegister, modRegisterValue - amount)
            }
        }
    }
}