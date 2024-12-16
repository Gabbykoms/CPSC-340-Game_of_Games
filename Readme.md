# Game of Games Repository

This repository contains the implementation of the **Game of Games**, an interactive program where players can select and play a variety of mini-games. Each game tracks wins and losses for Player 1 and Player 2, culminating in an overall scoreboard and winner declaration.

## Overview

The primary entry point for the application is the `GameOfGames` class, which provides a menu-driven interface for users to choose and play any of the available games. The following games are implemented:

- **Coin Flip Game**: A game where the player guesses the outcome of a coin flip.
- **Even-Odd Game**: A number-based guessing game focusing on odd and even predictions.
- **Find the Thimble**: A guessing game where players predict which hand hides the thimble.
- **Guess the Number**: A classic game where players attempt to guess a randomly selected number.
- **Red Thread Game**: A game involving probability and guessing outcomes.

## Classes Included

### Game Classes

- **`CoinFlipGame.java`**  
  Implements the Coin Flip Game.

- **`EvenOddGame.java`**  
  Implements the Even-Odd Game.

- **`FindTheThimble.java`**  
  Implements the Find the Thimble Game.

- **`GuessTheNumber.java`**  
  Implements the Guess the Number Game.

- **`RedThreadGame.java`**  
  Implements the Red Thread Game.

### Test Classes

- **`CoinFlipGameTest.java`**  
  Test class for the Coin Flip Game.

- **`EvenOddGameTester.java`**  
  Test class for the Even-Odd Game.

- **`FindTheThimbleTest.java`**  
  Test class for the Find the Thimble Game.

- **`GuessTheNumberTest.java`**  
  Test class for the Guess the Number Game.

- **`RedThreadGameTest.java`**  
  Test class for the Red Thread Game.

### Core Class

- **`GameOfGames.java`**  
  The main class that integrates all the mini-games into a unified program. It handles game selection, score tracking, and the final scoreboard.

## How to Run

1. **Clone this repository**:
   ```bash
   git clone <repository-url>
   ```
2. **Navigate to the project directory**:

```bash
cd GameOfGames
```

3. **Compile all Java files**:

```bash
javac *.java
```

4. **Run the GameOfGames program**:

```bash
javac GameOfGames
```

5. **Follow the prompts in the terminal to select and play the games. Type Quit to exit**.
