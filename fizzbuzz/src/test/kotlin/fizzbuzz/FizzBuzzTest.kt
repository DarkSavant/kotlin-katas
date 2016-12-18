package fizzbuzz

import io.kotlintest.KTestJUnitRunner
import io.kotlintest.specs.FlatSpec
import org.junit.runner.RunWith

@RunWith(KTestJUnitRunner::class)
class FizzBuzzTest : FlatSpec() {
    init {
        "counting to 1" should "be 1" {
            countTo(1) shouldBe "1"
        }

        "counting to 2" should "be '1 2'" {
            countTo(2) shouldBe "1 2"
        }

        "counting to 3" should "contain Fizz" {
            countTo(3) shouldBe "1 2 Fizz"
        }

        "counting to 5" should "contain Buzz" {
            countTo(5) shouldBe "1 2 Fizz 4 Buzz"
        }

        "counting to 16" should "contain FizzBuzz" {
            countTo(16) should endWith("Fizz 13 14 FizzBuzz 16")
        }
    }
}
