package at.ac.fhcampuswien

import java.util.Scanner


class App {
    fun playNumberGame(digitsToGuess: Int = 4) {
        val generatedNumber = generateRandomNonRepeatingNumber(digitsToGuess)
        var guess: Int
        val scanner = Scanner(System.`in`)

        do {
            println("Guess the $digitsToGuess-digit number:")
            guess = scanner.nextInt()

            val result = checkUserInputAgainstGeneratedNumber(guess, generatedNumber)
            println("Output: ${result.n}:${result.m}")

        } while (result.m != digitsToGuess)

        println("Congratulations! You've guessed the number correctly.")
    }

    val generateRandomNonRepeatingNumber: (Int) -> Int = { length ->
        if (length !in 1..9) throw IllegalArgumentException("Length must be between 1 and 9")
        (1..9).shuffled().shuffled().take(length).joinToString("").toInt()
    }


    val checkUserInputAgainstGeneratedNumber: (Int, Int) -> CompareResult = { input, generatedNumber ->
        val inputStr = input.toString()
        val genStr = generatedNumber.toString()

        if (inputStr.length != genStr.length) throw IllegalArgumentException("Input and generated number must have the same number of digits.")

        var correctDigits = 0
        val correctPositions = inputStr.zip(genStr).count { (inputDigit, generatedDigit) ->
            val isCorrectPosition = inputDigit == generatedDigit
            if (isCorrectPosition || generatedNumber.toString().contains(inputDigit)) {
                if (isCorrectPosition || !isCorrectPosition && inputStr.count { it == inputDigit } == 1) {
                    correctDigits++
                }
            }
            isCorrectPosition
        }

        CompareResult(correctDigits, correctPositions)
    }

}

fun main() {
    val app = App()
    app.playNumberGame() // Default 4 digits
    // app.playNumberGame(6) // Example with 6 digits
}

