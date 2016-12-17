package com.curtiscooley.bowling

class Bowling() {
    val rolls = IntArray(21, {0})
    var rollIndex = 0
    val frames : MutableList<Frame> = mutableListOf()


    fun score(): Int {
        return frames.sumBy(Frame::score)
    }

    fun  roll(ballOne: Int, ballTwo: Int) {
        frames.add(RegularFrame(rolls, rollIndex))
        rolls[rollIndex++] = ballOne
        rolls[rollIndex++] = ballTwo
    }

    fun spare(firstRoll: Int) {
        frames.add(SpareFrame(rolls, rollIndex))
        rolls[rollIndex++] = firstRoll
        rolls[rollIndex++] = 10 - firstRoll
    }

    fun strike() {
        frames.add(StrikeFrame(rolls, rollIndex))
        rolls[rollIndex++] = 10
    }

    fun tenth(firstRoll: Int, secondRoll: Int, optionalRoll: Int) {
        frames.add(TenthFrame(rolls, rollIndex))
        rolls[rollIndex++] = firstRoll
        rolls[rollIndex++] = secondRoll
        rolls[rollIndex] = optionalRoll
    }
}

interface Frame {
    fun score() :Int
    fun sum(rolls: IntArray, index: Int, to: Int) = rolls.slice(index..to).sum()
}

data class TenthFrame(val rolls: IntArray, val rollIndex: Int) : Frame {
    override fun score(): Int {
        return sum(rolls, rollIndex, rollIndex + 2)
    }
}

data class RegularFrame(val rolls: IntArray, val index: Int) : Frame {
    override fun score(): Int {
        return sum(rolls, index, index + 1)
    }
}

data class SpareFrame(val rolls: IntArray, val index: Int) : Frame {
    override fun score(): Int {
        return sum(rolls, index, index + 2)
    }

}

data class StrikeFrame(val rolls: IntArray, val index: Int) : Frame {
    override fun score(): Int {
        return sum(rolls, index, index + 2)
    }
}