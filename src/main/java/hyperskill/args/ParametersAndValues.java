package hyperskill.args;

/*
 * Write a program that takes command-line arguments in the format:

parameter1 value1 parameter2 value2 ...
and outputs them in the standard output in the format:

parameter1=value1
parameter2=value2
...
It is guaranteed, that each parameter is followed by a value.

Please, do not rename the provided class Problem.


Sample Input: 
config-path /something/there config-format json 
Sample Output: 
config-path=/something/there 
config-format=json 
 */
public class ParametersAndValues {

    public static void main(String[] args) {
        for (int i = 0, j = 1; j < args.length; i += 2, j += 2) {
            System.out.println(args[i] + "=" + args[j]);
        }
    }
}
