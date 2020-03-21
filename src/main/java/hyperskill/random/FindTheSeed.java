package hyperskill.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
 * Your job is to find the seed between A and B (both inclusively) that produces N pseudorandom numbers from 0 (inclusive) to K (exclusive). It should also have the maximum of these N numbers to be the minimum among all maximums of other seeds in this range.

Sounds complicated? Take a look at the example.

Here we have A = 7, B = 9, N = 4, K = 100. Let's suppose:

For the seed 7, we get sequence 45, 99, 23, 67 – the maximum is 99.
For the seed 8, we get 64, 34, 23, 9 – the maximum is 64.
For the seed 9, we get 78, 34, 0, 11 – the maximum is 78.
Then the minimum among these maximums is 64.  That means, in this example, the seed we are looking for is 8. 

The input contains numbers A, B, N, K in a single line in this order.

Your task is to output 2 numbers: a seed and it's maximum. If there are some seeds with equal minimal maximums, you should output the seed that is less than all other seeds.

Sample Input 1:

0 100 5 1000
Sample Output 1:

18
270
Sample Input 2:

0 100 1000 1000
Sample Output 2:

5
993
Sample Input 3:

0 100 10000 1000
Sample Output 3:

0
999
 */
public class FindTheSeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add nums:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int max = k;
        int seed = 0;
        Random random = new Random();
        
        Map<Integer, Integer> seeds = new HashMap<>();
        for (int i = a; i <= b; i++) {
            random.setSeed(i);
            Integer[] arr = new Integer[n];
            for (int j = 0; j < n; j++) {
                arr[j] = random.nextInt(k);
            }

            Arrays.sort(arr, Collections.reverseOrder());
            System.out.println("Seed: " + i);
            System.out.println(Arrays.toString(arr));
            seeds.put(i, arr[0]);
            if (max > arr[0]) {
                max = arr[0];
                seed = i;
            }

            System.out.println(seed);
            System.out.println(max);
            System.out.println();
        }
        Map<Integer, Integer> map = seeds
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new));
        System.out.println(seed);
        System.out.println(max);
        System.out.println(map);
        scanner.close();
        
    }
}
