package hyperskill.projects.stage6;

import java.util.Scanner;

/*
 * Add some statistics features. We suggest you implement the following:

Action log saves the application log to the given file. Save all lines that have been input in or output to the console to the file. You can use a list to store the lines.
Action hardest card prints the term of the card that has the most mistakes. You can store the mistake count in a map. If there are no cards with mistakes, you should print There are no cards with errors.. And for multiple hardest cards, you should list them all, like in the example below.
Action reset stats erases the mistake counts for all cards.
Also you should update serialization/deserialization to store sets of three items (term, definition, mistakes) instead of pairs (term, definition).

Example

The symbol > represents the user input. Notice that it's not the part of the input.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
There are no cards with errors.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> import
File name:
> capitals.txt
28 cards have been loaded.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
The hardest card is "France". You have 10 errors answering it.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> ask
How many times to ask?
> 1
Print the definition of "Russia":
> Paris
Wrong answer. (The correct one is "Moscow", you've just written the definition of "France" card.)

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
The hardest cards are "Russia", "France". You have 10 errors answering them.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> reset stats
Card statistics has been reset.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> hardest card
There are no cards with errors.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> log
File name:
> todayLog.txt
The log has been saved.

Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):
> exit
Bye bye!
 */
public class Stage6 {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        boolean actionFlag = true;
        while (actionFlag) {
            System.out.println("Input the action (add, remove, import, export, ask, exit)");
            // System.out.println("add action");
            String actionName = scanner.nextLine();
            if (actionName.equals("exit")) {
                System.out.println("Bye bye!");
                actionFlag = false;
            }
        }
        scanner.close();
    }

}
