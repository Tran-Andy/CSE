# CSE 1325 Assignment 4

This assignment focuses on interfaces and exception handling.

## Part 1: Exception Handling

In part 1, you will make a program more robust to bad input using exception handling.
This part uses the `Player`, `Weapon`, and `GameUtilities` classes.
You are free to use the classes that you have created in previous assignments.

There are 3 areas in which exception handling will be used:
1. Opening a file to load `Player` data.
2. Parsing CSV from the file.
3. Validating a name for character creation.

### `CsvReadException` Class

Create a new exception named `CsvReadException` which inherits from `Exception`.
The class should have a constructor which takes a `String` as input.
This `String` will be stored to a `private` instance field named `data`.
This instance field will reflect the raw CSV data that caused this exception.

Override the `toString()` method in this class and have it return a `String` that prints the exception class name followed by `data`.

### `Player` File Exception Handling

In the `Player` class, write a factory constructor method named `loadFromCsv` which takes a `String` as input and returns a new `Player` object or `null`, depending on the input.
A line of CSV data should be organized in the following way:
- Name
- HP
- STR
- DEX
- CON
- Weapon Name
- Weapon Dice Type
- Weapon Bonus

This method will attempt to parse a line of raw CSV data in order to fill out the attributes of the `Player` object.
Your code should catch any `NumberFormatExceptions` when parsing numeric data.
Additionally, it should check to see if the original input is a valid line of CSV data (e.g. splitting the string on commas should return a fixed number of attributes).

If the input is invalid or there is an exception while parsing the data, this method should throw a `CsvReadException` containing the raw line of CSV that caused the error.
This will be printed out in part 3.

### `Player` Name Exception Handling

Write a method `validateName` which validates a player name based on the following
criteria:
- Must start with a capital letter.
- Must not contain numbers or special characters.
- Cannot be longer than 24 characters.

If an input does not match one of the above criteria, the method should throw a `ParseException`.
Set the message of the `ParseException` based on which criteria was not met. If multiple
criteria are not met, you can choose which message to include.
This method can be implemented in the `GameUtilities` class OR as a static method in the testing application in part 3.

## Part 2: Interfaces

For part 2, you will be implementing the `Comparable` interface in the `Creature` class.
Override the `compareTo` method so that the creatures are sorted by HP.
You can choose between ascending or descending.

## Part 3: Test Application

In the final part, you should implement an application that will showcase the features
implemented in parts 1 and 2. The application will have a main menu with two options:
1. Test name validation
2. Test player file loading and sorting

### Testing Name Validation

Write a method in the testing application which tests the name validation method from part 1.
It should prompt the user to enter a name and pass it as input to the method.
This method should catch a `ParseException` that is thrown from the method.
If an exception is thrown, print out the error message in the exception (not the full stack trace).

### Testing `Player` File Loading and Sorting

Write a method which tests loading player files and sorting the loaded data.
Given a directory of data (provided in this repository), your code should search through the directory and load every CSV file contained therein.
If the file cannot be found, print the `FileNotFoundException` error message and skip to the next one.
For each file, it should attempt to load a new `Player` object using the `loadFromCsv` method created in part 1.

This method will catch a `ReadCsvException` when loading the data.
If the exception is thrown, print the warning message and skip to the next file in the list.
Otherwise, the `Player` object should be added to an `ArrayList<Creature>`.

With the data that is loaded, sort it using `Arrays.sort()` to test the interface implemented in part 2.
Print the sorted array, showing one player and their stats per line.