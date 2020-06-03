package hyperskill.projects.linear.stage5;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        GaussianElimination solution = new GaussianElimination();
        File in = new File("src/main/java/hyperskill/projects/linear/stage5/in.txt");
        // File in = new File(args[1]);
        File out = new File("src/main/java/hyperskill/projects/linear/stage5/out.txt");
        // File out = new File(args[3]);
        solution.read("2 2\n" +
                "i -i i\n" +
                "-i i i");
        solution.solve();
        solution.getSolution();
        solution.write(out);
    }
}
