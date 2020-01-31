package snippets.chockolate;

import java.util.Scanner;

/**
 * Czekolada ma kszta³t prostok¹ta, podzielonego na segmenty NxM. Mo¿esz
 * podzieliæ ten tabliczkê czekolady na dwie czêœci pojedyncz¹ lini¹ prost¹
 * (tylko raz). SprawdŸ, czy mo¿esz oderwaæ dok³adnie K segmentów od czekolady.
 * Ka¿dy segment to 1x1.
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
