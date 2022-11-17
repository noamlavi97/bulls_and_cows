# Bulls and cows guessing game
This is an assignment from the course 'Java advanced programing', 20554 at the Open University of Israel
Assignment 11, Q1 (semester 2023A).

Bulls and cows is a game where the player has to guess a sequence of 4 numbers.
On each guess, the program tells the user how many of the guess were 'bulls' (the correct digit in the correct location), and how many were 'cows' (the correct digit at the wrong location). The digit might not appear in the hidden sequence at all.

More info can be found in [Wikipedia](https://en.wikipedia.org/wiki/Bulls_and_Cows)

To run the project:
1.   Clone
2.   cd into the cloned directory
3.   run.bat

To re-compile the project yourself:
1. cd into src->game_of_life directory
2. List all the files in the directory: `dir /s /B *.java > sources.txt`
3. Compile: `javac -d . @sources.txt`
4. Run using the command: `java bulls_and_cows.Game`