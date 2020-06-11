package hyperskill.projects.numericalConverter.stage1;

/*
If you don't know what's a numeral system, take a look at Wikipedia. This video explains various numeral systems and conversation between them.

Implement a program that outputs two numbers: the first number is decimal and the second one is binary. The numbers must be equal. You can choose a number you like.

This stage is auto-graded. The grader will check that:

you output a single line,
there are two numbers,
the first number is decimal,
the second number is binary (it starts with 0b and contains only 0 and 1),
the first number is equal to the second one.
Notice that you do not need to enter anything into the program, you should print a line prepared in advance. A single String is expected to be printed.

Examples
Example 1:

10 = 0b1010
Example 2:

2 is equal to 0b10
 */
public class Main {
    public static void main(String[] args) {
        int num = 10;
        System.out.printf("%d = 0b%s", num, Integer.toBinaryString(num));
    }
}
