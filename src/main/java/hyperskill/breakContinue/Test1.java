package hyperskill.breakContinue;

public class Test1 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (char letter = 'a'; letter <= 'f'; letter++) {
                if (letter < 'f') {
                    continue;
                }
                System.out.println(letter);
            }
        }
    }
}
