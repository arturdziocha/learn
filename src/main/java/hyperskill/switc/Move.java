package hyperskill.switc;

import java.util.Scanner;

/*
 * Write a program, which reads the number of direction 
 * (1 – up, 2 – down, 3 – left, 4 – right, 0 – do not move) 
 * and outputs the text «move up» (or «move down», or «move left», or «move right», or «do not move» depending on the entered number). 
 * If it is a number that does not belong to any of the listed directions, the program should output: «error!»

Note: the output text should exactly match the sample, including the letters’ case and location of spaces.
 */
public class Move {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int move = scanner.nextInt();
        String out = "move ";
        switch (move) {
            case 1:
                out += "up";
                break;
            case 2:
                out += "down";
                break;
            case 3:
                out += "left";
                break;
            case 4:
                out += "right";
                break;
            case 0:
                out = "do not move";
                break;
            default:
                out = "error!";
                break;
        }
        System.out.println(out);

    }

}
