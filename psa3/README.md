File Header:
This file contains my answers to the vim and linux related questions
in the PSA instructions. This file also contains my summary for the
summary portion of the PSA.

Mark Choe
A13917840
mychoe@ucsd.edu

Vim Related Questions:
1. In command mode, input ":" followed by the number line you
would like to jump to in order to jump to that number line.
2. In command mode, input ":u" to undo changes in vim.
3. In command mode, input ":/" before the term you would like to search.
4. In command mode, just input "gg=GG" to fix the indentation.
5. In command mode, input ":tabn" to switch to the next open file.
6. a. In command mode, just input "w" to move forward one word.
b. In command mode, just input "b" to move backward one word.

Unix/Linux Related Questions:
7. To remove all .class files, input rm * before .class.
8. a. To remove an empty Unix directory input "rmdir".
b. To remove a non-empty Unix directory input "rmdir -r".
9. To clear the terminal screen input "clear" or just hit enter.
10. Swap files are a type of swap space. They exist to allow for memory to be
    freed up. To restore from a swap file input ":recover" in the swap file. To
    remove a swap file input the swap file name after "rm ."

Implementation:
Board.java:
My approach to implementing this program was to first attempt to follow the PSA
and discussion instructions. To check if I correctly followed these
instructions, I used the provided tester and sketched out how my code would
work.
GameManager.java:
My approach to implementing this program was to first attempt to follow the PSA
and discussion instructions. However, when I got stuck, I would read piazza and
the book. I used the Game2048.java file to play my game and check for errors.

Summary:
This entire program lets the user play the game 2048. This program either gets
the game board by making a new one or getting a previously saved board. This
program then lets the user put in what moves he or she wants to do and moves 
the board accordingly. After a move, this program adds a random tile. If the
move is not allowed, the program will give the user the instructions on how
to play. If the user quits the game, the program then saves the board for later 
use.
