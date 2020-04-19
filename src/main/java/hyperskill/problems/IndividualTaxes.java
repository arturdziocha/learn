package hyperskill.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
In some country, there are N companies, and the law of that country say that the taxes of each company are individual and appointed by a president. President wants to know which company pays the most taxes. But sadly, none of the president's proxies know math very well, so this work is transferred to you. Can you solve this problem?

The first line of the input contains N - the number of companies in this country.
The second line contains yearly incomes of each company. All numbers are non-negative integers.
The third line contains individual taxes for each company in percents of the company's income. All numbers are integers from 0 to 100 inclusive.

You should output № of the company that pays the most taxes. Keep in mind that the enumeration of the companies starts from number 1. If there are several companies with the same payments sizes, output the number of the company with the lowest number.

Sample Input 1:

1
1
1
Sample Output 1:

1
Sample Input 2:

2
50 100
10 10
Sample Output 2:

2
Sample Input 3:

3
50 100 300
100 20 0
Sample Output 3:

1
 */
public class IndividualTaxes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        int howMany = Integer.parseInt(scanner.nextLine());
        if (howMany > 0) {
            List<Float> incomes =
                    Arrays.stream(scanner.nextLine().split(" "))
                            .map(i -> Float.parseFloat(i))
                            .collect(Collectors.toCollection(ArrayList::new));
            List<Float> taxes =
                    Arrays.stream(scanner.nextLine().split(" "))
                            .map(i -> Float.parseFloat(i))
                            .collect(Collectors.toCollection(ArrayList::new));
            List<Float> pay = IntStream.range(0, howMany)
                    .mapToObj(i -> {
                        return (incomes.get(i) * taxes.get(i)) / 100;
                    })
                    .collect(Collectors.toCollection(ArrayList::new));

            Optional<Float> max = pay.stream().max(Comparator.naturalOrder());
            max.ifPresent(m -> System.out.println(m > 0 ? pay.indexOf(m) + 1 : 0));
        }
    }
}
