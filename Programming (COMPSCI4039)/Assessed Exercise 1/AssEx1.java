/* 
    Instructions - Assessed Exercise 1
    - This exercise tests the things you've learnt in the first week of the semester.
    - Add your code to this file, leaving the main method unchanged (except for task 3).
    - Add all of your methods *below* the main method, in question order.
    - Each of the tasks involves writing a single method. You do not need to add additional main methods.
    - The total number of marks is 22.
    - Read the instructions for each task *carefully*.
    - Submit a single .java file on moodle by the deadline (details on moodle).
    - Do not change the name of the Java file, but ensure you add your name and 
        matric as requested below...
    - You do not need to add any additional import lines.
    - Everything you need to do these tasks is covered in the week 1 lectures and slides.
*/

/*
    Non task-specific marks:
     - Add a comment with your name and matric here - Yu-Sung Hsu / Student ID: 2540296H / Email: 2540296H@student.gla.ac.uk [1 mark]
     - Clear code commenting [1 mark]
     - Use of correct Java variable and method naming conventions [1 mark]
*/

/**
    Author: Yu-Sung Hsu
    Email: 2540296H@student.gla.ac.uk
    Student ID: 2540296H
    COMPSCI4039 Programming (IT) Assessed Exercise 1
*/

import java.util.Scanner;

public class AssEx1 {
    public static void main(String[] args) {
        String date = "01/01/21";
        
        /* EXAMPLE TASK
            This is just here to show you what you should do.
            Create a method called comment that includes nothing but a single comment.
            It will be called by the line below.
            Look below main to 
        */
        comment();

        /* Task 1 [2 marks]
            Create a method called welcome that:
                - prompts the user to enter their name
                - saves their name in a string variable
                - prints the word "Hello" followed by whatever the user entered, followed by
                - whatever is stored in the String date.
        */
        welcome(date);

        /* Task 2 [3 marks]
            Write a method called divisors that is passed a single integer
            argument n. It should print out (on separate lines) all of the integers
            between 1 and n that divide n exactly (i.e. with remainder zero).
            For example divisors(12) should print:
            1
            2
            3
            4
            6
            12
            Your method *must* use a loop
        */
        int n = 10;
        divisors(n);

        /* Task 3 [3 marks]
            Write a method called check that takes an integer as an argument and 
            returns a boolean value that is true if the integer is equal to 12, or is greater
            than 5 and less than 10. It should return false otherwise.
            Call the method four times with the integers
            1, 6, 11 and 12 respectively, printing the output each time on a new line. 
            You *must* use the and (&&) operator in your solution
        */
        System.out.println(check(1));
        System.out.println(check(6));
        System.out.println(check(11));
        System.out.println(check(12));

        /* Task 4 [6 marks]
            Write a method called calculator that prompts the user to input 
            an integer, an operator ('+', '-', '*', or '/') and finally another integer.
            The user should enter them *on the same line* and *separated by spaces*.
            (the space separation is important!!)
            The method should then perform the calculation, storing the result
            as a double. The operator '/' should perform floating point (not int) division.
            The full expression including the result should be printed using String.format
            where the result should be 7 characters long and have two digits after the decimal point.
            e.g. if the user types:
            4 / 3
            The program should output:
            "4 / 3 =    1.33"
            You don't need to do any error checking on the user input.
            Hint: if you have the whole expression stored as a String, you can
            split it up using a Scanner initialised with the String.
        */
        calculator();

        /* Task 5 [5 marks]
            Write a method called products. It should takes two integers as arguments, 
            corresponding to a number of rows and a number of columns.
            If either number is less than 0 or bigger than 20, the method should print an 
            error and return. This checking of the row and column numbers should use a separate method that
            checks if a single integer is <0 or >20. This method should be called twice from within products,
            once for the number of rows, once for columns.

            If the number of rows and columns is >=0 and <=20, the method should 
            print a table in which each entry is the product of the row and column positions (which
            go from 1 to the number of rows / columns respectively).


            The table should include heading rows and columns.
            For example, if rows=4 and columns=5, the table should look *exactly* like this:

   |  1  2  3  4  5
-------------------
  1|  1  2  3  4  5
  2|  2  4  6  8 10
  3|  3  6  9 12 15
  4|  4  8 12 16 20

            Each entry should be printed using String.format and its length should be the length of
            the largest value in the table plus one (i.e. in the example above, each entry has length
            3 because the largest value is 20 ("20" is two characters)).
            So, if, for example, the largest number is >= 100 then all lengths should be longer.
            For example, a table with 12 rows and 13 columns should look *exactly* like this:

    |   1   2   3   4   5   6   7   8   9  10  11  12  13
---------------------------------------------------------
   1|   1   2   3   4   5   6   7   8   9  10  11  12  13
   2|   2   4   6   8  10  12  14  16  18  20  22  24  26
   3|   3   6   9  12  15  18  21  24  27  30  33  36  39
   4|   4   8  12  16  20  24  28  32  36  40  44  48  52
   5|   5  10  15  20  25  30  35  40  45  50  55  60  65
   6|   6  12  18  24  30  36  42  48  54  60  66  72  78
   7|   7  14  21  28  35  42  49  56  63  70  77  84  91
   8|   8  16  24  32  40  48  56  64  72  80  88  96 104
   9|   9  18  27  36  45  54  63  72  81  90  99 108 117
  10|  10  20  30  40  50  60  70  80  90 100 110 120 130
  11|  11  22  33  44  55  66  77  88  99 110 121 132 143
  12|  12  24  36  48  60  72  84  96 108 120 132 144 156

            
        */
        products(13,7);
        products(-2,7);
        products(3,6);
        products(12,13);
        products(5,25);
    }

    /*
        Here's an example of how you write the solutions!
        Hint: you may find it easier to comment out method calls above
        until you've written the methods!
    */
    public static void comment() {
        // just a comment!
    }

    /**
        A method that performs Task 1.
        This method askes the user for their name and print "Hello", followed by user inputs and date.
         @param date A `String` passed into the function representing a date.
    */
    public static void welcome(String date) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your name, followed by return: ");
        String name = userInput.nextLine();
        System.out.println("Hello" + " " + name + " " + date);
    } 

    /**
        A method that performs Task 2.
        This method prints out all the integers between 1 and a specified number (n) that divide the number exactly.
        This method should be implemented using a loop.
        @param n The specified number as `int`.
    */
    public static void divisors(int n) {
        for (int idx = 1; idx <= n; idx++) {
            if (n % idx == 0) {
                System.out.println(idx);
            }
        }
    }

    /**
        A method that performs Task 3.
        This method check the inputted integer against specifed rules and returns a boolean.
        @param input An `int` to be checked.
    */
    public static boolean check(int input) {
        return (input == 12 || input > 5 && input < 10);
    }

    /**
        A method that performs Task 4.
        This method prompts the user to input an integer, then an operator, and finally another integer on the same line, separated by spaces. The method would perform the calculation and return the result as a double.
        The result would be printed with 2 digits after decimal point and be 7 characters long.
    */
    public static void calculator() {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("Please input an integer, followed by an operator(+, -, *, /), and another integer, all separated by spaces.");
        String expression = userInput.nextLine();

        userInput.close();

        Scanner parser = new Scanner(expression);

        int first = parser.nextInt();
        String operator = parser.next();
        int second = parser.nextInt();

        parser.close();

        // Prepare a variable to store results.
        double result = 0.0;

        // Deal with +, -, *, / with for if-else cases.
        if (operator.equals("+")) {
            result = first + second;
        } else if (operator.equals("-")) {
            result = first - second;
        } else if (operator.equals("*")) {
            result = first * second;
        } else if (operator.equals("/")) {
            // `(double)` is added to perform floating-point division.
            result = (double) first / second;
        }

        String output = String.format("%d %s %d = %7.2f", first, operator, second, result);
        System.out.println(output);
    }

    /**
        A method that performs Task 5.
        This method takes two integers (`rows` and `cols`) as input and prints a table of rows * cols.
        If either rows & cols is less than 0 or greater than 20, the function would print an error and return.
        If one of rows or cols is 0, the table would be too small, so it would print nothing and return.
        @param rows An `int` that represents the rows of the printed table.
        @param cols An `int` that represents the columns of the printed table.
    */
    public static void products(int rows, int cols) {
        // Check whether the inputs are valid with a helper method.
        if (guardValidInput(rows)) {
            System.err.println("Error: Invalid rows.");
            return;
        }

        if (guardValidInput(cols)) {
            System.err.println("Error: Invalid columns.");
            return;
        }

        // Check if one of rows or cols is 0; if yes, print nothing and exit.
        if (rows == 0 || cols == 0) {
            return;
        }
        
        // For-loop indexes
        int idx = 0, jdx = 0;
        
        // An int to keep track of how many characters in the header row
        // to generate a line of dash that has the same count with the header line. 
        int headerRowCharCount = 0;

        // Get the length of each value in the table.
        int largestValue = rows * cols;
        int spaces = String.format("%d", largestValue).length() + 1;

        // Generate the format string for each item in the table.
        String format = "%" + String.format("%d", spaces) + "d";

        // Print the empty entry for the header row.
        for (idx = 0; idx < spaces; idx++) {
            System.out.print(" ");
            headerRowCharCount += 1;
        }

        System.out.print("|");
        headerRowCharCount += 1;

        // Print the entries in the header row
        for (idx = 1; idx <= cols; idx++) {
            System.out.print(String.format(format, idx));
            headerRowCharCount += spaces;
        }

        System.out.print("\n");
        
        // Print a row of separator
        for (idx = 0; idx < headerRowCharCount; idx++) {
            System.out.print("-");
        }
        
        System.out.print("\n");

        // Print each row
        // The outer loop indexes through each row.
        for (idx = 1; idx <= rows; idx++) {
            // Print the row index & separator.
            System.out.print(String.format(format, idx));
            System.out.print("|");

            // The inner loop prints each entry formatted by String.format.
            for (jdx = 1; jdx <= cols; jdx++) {
                System.out.print(String.format(format, idx * jdx));
            }

            System.out.print("\n");
        }
    }

    /**
        A helper method of products that checks whether the input is within ranges.
        The method returns a boolean value, with `true` meaning not within the range and `false` meaning the opposite.
        @param input An `int` passed into the method to be checked.
    */
    public static boolean guardValidInput(int input) {
        return (input < 0 || input > 20);
    }
}
