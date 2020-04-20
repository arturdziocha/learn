package hyperskill.enums;

import java.util.Arrays;
/**
 * Find how many enums start with "STAR"
 */
public class StartsWith {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(Secret.values()).filter(s -> s.name().startsWith("STAR")).count());
    }
}

enum Secret {
    STAR,
    CRASH,
    START,
    STARTA,
    STARTTTA;
}