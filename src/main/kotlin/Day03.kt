object Day03 {

    val SIDES = 4

    fun steps(input: Int): Int {
        if (input <= 1) {
            return 0
        }

        var result = 0
        var ring = 1
        var corner = 2
        var increasing = false
        var cornersHit = 0
        var increasingRing = true

        for (index in 2..input) {
            if (increasingRing) {
                result++
                increasing = false
                increasingRing = false
            } else {
                if (increasing) result++ else result--
            }

            if (result == corner) {
                increasing = false
                cornersHit++
            }
            if (result == ring) {
                increasing = true
            }

            if (cornersHit == SIDES) {
                ring++
                corner += 2
                cornersHit = 0
                increasingRing = true
            }
        }

        return result
    }
}