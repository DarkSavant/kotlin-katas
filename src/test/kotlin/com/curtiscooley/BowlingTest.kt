package com.curtiscooley

import io.kotlintest.matchers.be
import io.kotlintest.specs.FlatSpec
import kt.times.times
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class BowlingTest : FlatSpec() {

    init {
        "No pins" should "score 0" {
            val game = Bowling()
            game.roll(0, 0)
            game.score() shouldBe 0
        }

        "One pin each roll" should "score 2" {
            val game = Bowling()
            game.roll(1,1)
            game.score() shouldBe 2
        }

        "4,3 then 8,0" should "score 15" {
            val game = Bowling()
            game.roll(4, 3)
            game.roll(8, 0)
            game.score() shouldBe 15
            game.frames.size shouldBe 2
        }
    }

    @Test
    fun spare() {
        val game = Bowling()
        game.spare(5)
        game.roll(5,4)
        assertThat(game.score(), `is`(24))
    }

    @Test
    fun strike() {
        val game = Bowling()
        game.strike()
        game.roll(4,5)
        assertThat(game.score(), `is`(28))
    }

    @Test
    fun perfect() {
        val game = Bowling()
        9 times  { game.strike() }
        game.tenth(10, 10, 10)
        assertThat(game.score(), `is`(300))
    }

    @Test
    fun nearPerfectGame() {
        val game = Bowling()
        9 times  { game.strike() }
        game.tenth(10, 10, 9)
        assertThat(game.score(), `is`(299))
    }

    @Test
    fun spareStrikeCombo() {
        val game = Bowling()
        game.roll(4,5)
        game.spare(8)
        game.strike()
        game.spare(3)
        game.roll(8,1)
        assertThat(game.score(), `is`(76))
    }
}
