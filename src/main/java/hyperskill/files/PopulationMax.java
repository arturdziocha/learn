package hyperskill.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class PopulationMax {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        File file = new File("src/main/java/hyperskill/files/population.txt");
        NumberFormat format = NumberFormat.getInstance(Locale.US);

        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            String largestIncreaseYear = "";
            long largestIncrease = 0l;
            String currentYear = scanner.next();
            long prevPopulation = format.parse(scanner.next()).longValue();
            long currentPopulation = 0l;

            while (scanner.hasNext()) {
                currentYear = scanner.next();
                currentPopulation = format.parse(scanner.next()).longValue();
                if (currentPopulation - prevPopulation > largestIncrease) {

                    largestIncrease = currentPopulation - prevPopulation;
                    largestIncreaseYear = currentYear;                    
                }
                prevPopulation = currentPopulation;

            }
            System.out.println(largestIncreaseYear);
        } 
    }
}
