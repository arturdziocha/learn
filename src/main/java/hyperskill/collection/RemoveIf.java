package hyperskill.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveIf {
    public static Collection<String> filterPhones(Collection<String> phones,
                                                  Collection<String> blacklist) {
        phones.removeIf(blacklist::contains);
        phones.removeAll(blacklist);
        return phones;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<String> phones = Arrays.asList(scanner.nextLine().split("\\s+"));
        Collection<String> blockList = Arrays.asList(scanner.nextLine().split("\\s+"));

        Collection<String> nonBlockedPhones = RemoveIf.filterPhones(
                new ArrayList<>(phones), new ArrayList<>(blockList));

        System.out.println(nonBlockedPhones.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
}
