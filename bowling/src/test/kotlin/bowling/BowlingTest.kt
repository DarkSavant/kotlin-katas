package bowling

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.FlatSpec
import kt.times.times
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class BowlingTest : FlatSpec() {

    init {
        "No pins" should "score 0" {
            val game = Bowling()
            game.roll(0, 0)
            game.score() shouldBe 0
        }

        "One pin each roll" should "score 2" {
            val game = Bowling()
            game.roll(1, 1)
            game.score() shouldBe 2
        }

        "7 pin frame then 8 pin frame" should "score 15" {
            val game = Bowling()
            game.roll(4, 3)
            game.roll(8, 0)
            game.score() shouldBe 15
            game.frames.size shouldBe 2
        }

        "spare" should "score one extra ball" {
            val game = Bowling()
            game.spare(5)
            game.roll(5, 4)
            game.score() shouldBe 24
        }

        "strike" should "score two extra balls" {
            val game = Bowling()
            game.strike()
            game.roll(4, 5)
            game.score() shouldBe 28
        }

        "perfect game" should "score 300" {
            val game = Bowling()
            9 times { game.strike() }
            game.tenth(10, 10, 10)
            game.score() shouldBe 300
        }

        "heart breaker" should "score 299" {
            val game = Bowling()
            9 times { game.strike() }
            game.tenth(10, 10, 9)
            game.score() shouldBe 299
        }

        "spares and strikes" should "score correctly" {
            val game = Bowling()
            game.roll(4, 5)
            game.spare(8)
            game.strike()
            game.spare(3)
            game.roll(8, 1)
            game.score() shouldBe 76
        }
    }
}
