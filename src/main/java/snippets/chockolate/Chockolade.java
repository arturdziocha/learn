package snippets.chockolate;

import java.util.Scanner;

/**
 * Czekolada ma kszta�t prostok�ta, podzielonego na segmenty NxM. Mo�esz
 * podzieli� ten tabliczk� czekolady na dwie cz�ci pojedyncz� lini� prost�
 * (tylko raz). Sprawd�, czy mo�esz oderwa� dok�adnie K segment�w od czekolady.
 * Ka�dy segment to 1x1.
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
