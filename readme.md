# MAD - Exercise 01
## Tasks
* Watch the Kotlin Crashcourse Video in Moodle or complete the tutorials **[Introduction to programming in Kotlin](https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)** and **[Kotlin fundamentals](https://developer.android.com/courses/pathways/android-basics-compose-unit-2-pathway-1
)**.
* Answer the questions inside this Readme.md file and push it to your repository.
* Submit your coding solution of the Number Guessing Game inside the repository.
* Submit the link to your repository in Moodle.

## Questions
### Describe how Kotlin handles null safety. What are nullable types and non-null types in Kotlin? (0,5 points)

> Kotlin handles null safety through its type system. Each type in Kotlin can be either nullable or non-nullable:

Non-null types cannot hold a null value. Attempting to assign null to such a type will result in a compile-time error.
Nullable types can hold a null value. They are declared by appending a ? to the type name.

```kotlin
val a: String = "Hello" // Non-null type. 'a' cannot be set to null.
var b: String? = "World" // Nullable type. 'b' can be set to null.
b = null // This is allowed because 'b' is a nullable type.
```
To safely use nullable types, Kotlin provides several mechanisms, including;
- The safe call operator **?.**
- the Elvis operator **?:**
- and the **!!** operator

to assert non-null when you are certain a value is not null.

### What are lambda expressions and higher order functions in Kotlin? Why would you store a function inside a variable? (0,5 points)

Lambda expressions in Kotlin are essentially anonymous functions that can be passed around as if they were values. Higher-order functions are functions that take functions as parameters or return functions.

You might store a function in a variable for various reasons, such as to pass it as an argument to a higher-order function, to delay its execution, or to dynamically determine which function to call.

Example of a lambda expression and storing it in a variable:

```kotlin
val sum: (Int, Int) -> Int = { x, y -> x + y }
```

Generated number: 8576
-	User input: 1234, Output: 0:0
-	User input: 5678, Output: 4:1
-	User input: 5555, Output: 1:1
-	User input: 3586, Output: 3:2
-	User input: 8576, Output: 4:4 -> user wins

Take a look into the provided code structure in `src/main/kotlin/App.kt`. Implement the following methods (lambda expressions):
- _playNumberGame(digitsToGuess: Int = 4)_ (1 point): The main game loop that handles user input and game state. Make use of _generateRandomNonRepeatingNumber_ and _checkUserInputAgainstGeneratedNumber_ here. This function also utilizes a default argument 
- _generateRandomNonRepeatingNumber_ (1 point): A lambda expression that generates a random number with non-repeating digits of a specified length.
- _checkUserInputAgainstGeneratedNumber_ (1 point): A lambda expression that compares the user's input against the generated number and provides feedback.

``CompareResult.kt`` This class is a data structure which helps with bundling the result of the comparison of the user input and the generated number. Look at the toSting() and use it in your output.

Run the project with `./gradlew run` and test your implementation with the provided tests in `src/test/kotlin/AppTest.kt` with `./gradlew test`.

# Project Structure
The project is structured into two main Kotlin files:

**App.kt**: Contains the main game logic and functions.

**AppTest.kt**: Contains unit tests for the various functions in App.kt.

