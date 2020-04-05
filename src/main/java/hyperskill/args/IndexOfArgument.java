package hyperskill.args;

/*Write a program that searches for an argument equal to "test" (without quotes), and then outputs its index in the array args. If it is not found, the program must output "-1".

Please, do not rename the provided class Problem.

Sample Input 1:

arg1 arg2 test
Sample Output 1:

2
Sample Input 2:

arg1 arg2 arg3    
Sample Output 2:

-1*/
public class IndexOfArgument {

    public static void main(String[] args) {
        int index = -1;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                index = i;
            }
        }
        System.out.println(index);
    }

}
