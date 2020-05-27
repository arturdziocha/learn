package hyperskill.projects.linear.stage5;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LinearSolution solution = new LinearSolution();
        File in = new File("src/main/java/hyperskill/projects/linear/stage5/in.txt");
        // File in = new File(args[1]);
        File out = new File("src/main/java/hyperskill/projects/linear/stage5/out.txt");
        // File out = new File(args[3]);
        solution.read(in);
        solution.solve();
        solution.write(out);
    }
}












