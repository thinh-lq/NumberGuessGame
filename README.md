# Number Guessing Game

A simple CLI-based number guessing game written in Java.

The computer randomly selects a number between 1 and 100, and the player tries to guess it within a limited number of attempts.

## Features

* 5 difficulty levels:

  * Easy — 10 chances
  * Medium — 5 chances
  * Hard — 3 chances
  * Nightmare — 2 chances
  * Impossible — 1 chance
* Provides hints during the game
* Indicates whether the target number is higher or lower than the guess
* Input validation
* Play multiple rounds
* Tracks the best score
* Displays the total number of games played

## Requirements

* Java JDK 8 or later
* Command-line interface

No external libraries are required.

## Project Structure

```text
NumberGuessGame/
├── src/
│   └── NumberGuessGame.java
└── .gitignore
```

## Run

Compile the project:

```bash
javac src/NumberGuessGame.java
```

Run the game:

```bash
java -cp src NumberGuessGame
```

## How to Play

1. Select a difficulty level.
2. The computer generates a random number between 1 and 100.
3. Enter your guess.
4. The game tells you whether the target number is higher or lower than your guess.
5. You can use one hint during each round.
6. Guess the number before running out of chances.
7. Choose whether to play another round.

## Example

```text
Welcome to the Number Guessing Game!

I'm thinking of a number between 1 and 100.

Please select the difficulty level:
1. Easy (10 chances)
2. Medium (5 chances)
3. Hard (3 chances)
4. Nightmare (2 chances)
5. Impossible (1 chance)

Enter your choice: 2

Great! You have selected the Medium difficulty level.
Let's start the game!

Do you want a hint? (y/n): n

Enter your guess: 50
Incorrect! The number is less than 50
Do you want a hint? (y/n): n

Enter your guess: 25
Incorrect! The number is greater than 25
Do you want a hint? (y/n): n

Enter your guess: 37
Congratulations! You guessed the correct number in 3 attempts
```

## Technologies

* Java
* `Random`
* `Scanner`

## Project Reference

This project is based on the [Number Guessing Game project](https://roadmap.sh/projects/number-guessing-game) from roadmap.sh.
