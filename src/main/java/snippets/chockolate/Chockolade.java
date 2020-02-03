package snippets.chockolate;

import java.util.Scanner;

/**
 * Czekolada ma kształt prostokąta, podzielonego na segmenty NxM. Możesz
 * podzielić ten tabliczkę czekolady na dwie częci pojedyncz� linię prostą
 * (tylko raz). Sprawdź, czy możesz oderwać dokładnie K segmentów od czekolady.
 * Każdy segment to 1x1.
 */
public class Chockolade {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Please add numbers");
        final int n = scanner.nextInt();
        final int m = scanner.nextInt();
        final int k = scanner.nextInt();

        if (k % n == 0 && m >= k / n || k % m == 0 && n >= k / m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        scanner.close();
    }
}
