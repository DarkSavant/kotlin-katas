package fizzbuzz

fun countTo(to: Int): String {
    var answer = ""
    for(n in 1..to) when {
        n divisibleBy 15 -> answer += "FizzBuzz "
        n divisibleBy 3 -> answer += "Fizz "
        n divisibleBy 5 -> answer += "Buzz "
        else -> {
            answer += "$n "
        }
    }
    return answer.trim()
}

private infix fun Int.divisibleBy(i: Int) = this % i == 0