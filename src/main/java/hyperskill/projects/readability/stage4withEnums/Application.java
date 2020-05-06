package hyperskill.projects.readability.stage4withEnums;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    private final TextStatistics textStatistics;

    Application(TextStatistics text) {
        this.textStatistics = text;
    }

    void run() {
        System.out.println(textStatistics);
        System.out
                .printf("Enter the score you want to calculate (%s, all):%n",
                    Stream.of(ReadabilityScores.values()).map(Enum::toString).collect(Collectors.joining(", ")));

        final String rsName = new Scanner(System.in).next().toUpperCase();
        final boolean isAll = rsName.equals(ReadabilityScores.ALL);
        Stream
                .of(ReadabilityScores.values())
                .filter(rs -> isAll || rs.name().equals(rsName))
                .peek(rs -> System.out.println(rs.getScoreAndAge(textStatistics)))
                .mapToInt(rs -> rs.getAge(textStatistics))
                .average()
                .ifPresentOrElse(this::printAverage, this::printErrorMessage);
    }

    private static void printErrorMessage() {
        System.out.println("Wrong name of Readability Score!");
    }

    private static void printAverage(double averageAge) {
        System.out.printf("This text should be understood in average by %.2f year olds.", averageAge);
    }    
}
