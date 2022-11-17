# CSE1325 Assignment 1

This assignment is for practicing basic Java programs using similar concepts that would have been established in CSE 1320.

## (30%) Problem 1

Create a program which rolls a set of dice based on the format `[NUM]d[DICE]+[CONSTANT]`.
The program will generate the roll with the help of Java's `java.util.Random` library and print the output to `stdout`.

**Requirements**
- If the input string is invalid, warn the user and `return`.
- Your program should at least support the following dice:
    - d4
    - d6
    - d8
    - d10
    - d12
    - d20
- `NUM` and `CONSTANT` are optional values. If `NUM` is omitted, assume it is 1. If `CONSTANT` is omitted, assume it is 0.
- Name the class and file `RollDice` and `RollDice.java`, respectively.

**Examples**

Rolls 2 d6 dice and adds a constant of 6.

```
$ java RollDice 2d6+6
15
```

Invalid input

```
$ java RollDice nd6+1
Invalid input
```

## (35%) Problem 2

Create a program which reads in a file of numbers and sorts them using `Array.sort`.
The file name should be given as input from the command line. You can assume
that the file given exists and contains at least one number. The program should do
nothing if a file is not given as input.

Some entries in the input file may not be numbers.
Your program should simply skip over them if that is the case.

**Requirements**

- **(9 points)** Read numbers from a file given via command line input.
- **(9 points)** Output the sorted entries to a file `out.txt`. The filename may be hard-coded.
- **(9 points)** The sorted values must be printed to the output file such that each number is on a new line.
- **(5 points)** Print the number of invalid entries found to `stdout`.
- **(3 points)** Close any resource handles before exiting the program.
- Use standard arrays only (not `ArrayList`)
- Name the class and file `SortNumbers` and `SortNumbers.java`, respectively.
- You do not need to handle exceptions. You can throw them as we did in the class examples.

## (35%) Problem 3

Create a program that prints a user's message to a log file in CSV format.
The logged data should include a username, message, and date of creation.
When the program is run, prompt the user for their username and message.
Use the `LocalDateTime` class to generate the date.

When writing the message data, look for the file in the current directory.
The log file should be created it it does not exist.
If it does exist, open it and append the user's date.
You can use `FileWriter` and `PrintWriter` for this.

**Requirements**

- **(10 points)** Read username and message from `stdin`.
- **(10 points)** Write the data for each user to a file with format `USERNAME-YYYY-MM-DD.log`.
- **(10 points)** Print each message on a new line in the file as CSV in the format `USER,MSG,DATE`.
- **(5 points)** Existing files should have the data appended to them.
- The date in the actual line of CSV can be the full date as returned by `LocalDateTime.toString()`.
- You do not need to handle exceptions. You can throw them as we did in the class examples.
