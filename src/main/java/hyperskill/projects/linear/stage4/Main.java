package hyperskill.projects.linear.stage4;
/*
Stage #4: When things get complicated

Description

This stage is devoted to various special cases of the algorithm.

Firstly, look at the first stage of the algorithm. It says that you should change the first row in a way that the first element of the row would be equal to 1. But what if the first element of the row is 0? Any multiplication of the row never let the first element of the row be equal to 1 because it would always be 0.

⎧⎩⎨⎪⎪⎪⎪⎪⎪0a21x1an1x1+a12x2+...+a1nxn=b1+a22x2+...+a2nxn=b2...+an2x2+...+annxn=bn
{
0	+
a
12
x
2
+...+
a
1
n
x
n
=
b
1
a
21
x
1
+
a
22
x
2
+...+
a
2
n
x
n
=
b
2
...
a
n
1
x
1
+
a
n
2
x
2
+...+
a
n
n
x
n
=
b
n


Because of that, you need to modify the algorithm. All rules will follow the example of a system of linear equations. The question marks next to the coefficients mean any value. The coefficients highlighted in red mean the ones mentioned in the rule.

1. Before the scaling the current row you should check if the corresponding element of the row is not equal to 0.
⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1+?x2+?x3+?x4+?x5=?0x1+1x2+?x3+?x4+?x5=?0x1+0x2+\red?x3+?x4+?x5=?0x1+0x2+?x3+?x4+?x5=?0x1+0x2+?x3+?x4+?x5=?
{
1
x
1
+?
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+1
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+\red?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+?
x
3
+?
x
4
+?
x
5
=?

2. If the coefficient is zero, the program should look for a non-zero coefficient under this coefficient. If such a coefficient is found in some row, you should swap this row with the current one. In the example below, rows 3 and 5 have been swapped.
⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1+?x2+?x3+?x4+?x5=?0x1+1x2+?x3+?x4+?x5=?0x1+0x2+0x3+?x4+?x5=?0x1+0x2+\red?x3+?x4+?x5=?0x1+0x2+\red?x3+?x4+?x5=?
{
1
x
1
+?
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+1
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+\red?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+\red?
x
3
+?
x
4
+?
x
5
=?


⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1+?x2+?x3+?x4+?x5=?0x1+1x2+?x3+?x4+?x5=?0x1+0x2+0x3+?x4+?x5=?0x1+0x2 + ?x3+?x4+?x5=?0x1+0x2+\green5x3+?x4+?x5=?
{
1
x
1
+?
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+1
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
 + ?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+\green5
x
3
+?
x
4
+?
x
5
=?


⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1+?x2+?x3+?x4+?x5=?0x1+1x2+?x3+?x4+?x5=?0x1+0x2+\green5x3+?x4+?x5=?0x1+0x2 + ?x3+?x4+?x5=?0x1+0x2+0x3+?x4+?x5=?
{
1
x
1
+?
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+1
x
2
+?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+\green5
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
 + ?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+?
x
4
+?
x
5
=?

3. If all the coefficients below the element are equal to zero, you should look for a non-zero coefficient to the right of the current one. If such a coefficient is found in some column, you should swap this column with the current one. Don't forget to remember this swap because after all, you need to swap them back to output the solutions in the right order. There could be a lot of swaps. In the example below, rows 3 and 4 have been swapped.
⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1 + ?x2 + ?x3+?x4+?x5=?0x1+1x2 + ?x3+?x4+?x5=?0x1+0x2+0x3+\red?x4+\red?x5=?0x1+0x2+0x3+?x4+?x5=?0x1+0x2+0x3+?x4+?x5=?
{
1
x
1
 + ?
x
2
 + ?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+1
x
2
 + ?
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+\red?
x
4
+\red?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+?
x
4
+?
x
5
=?


⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1 + ?x2 + ?x3 + ?x4+?x5=?0x1+1x2 + ?x3 + ?x4+?x5=?0x1+0x2+0x3+\green7x4+?x5=?0x1+0x2+0x3 + ?x4+?x5=?0x1+0x2+0x3 + ?x4+?x5=?
{
1
x
1
 + ?
x
2
 + ?
x
3
 + ?
x
4
+?
x
5
=?	0
x
1
+1
x
2
 + ?
x
3
 + ?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+\green7
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
 + ?
x
4
+?
x
5
=?	0
x
1
+0
x
2
+0
x
3
 + ?
x
4
+?
x
5
=?


⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1 + ?x2 + ?x4 + ?x3+?x5=?0x1+1x2 + ?x4 + ?x3+?x5=?0x1+0x2+\green7x4+0x3+?x5=?0x1+0x2 + ?x4+0x3+?x5=?0x1+0x2 + ?x4+0x3+?x5=?
{
1
x
1
 + ?
x
2
 + ?
x
4
 + ?
x
3
+?
x
5
=?	0
x
1
+1
x
2
 + ?
x
4
 + ?
x
3
+?
x
5
=?	0
x
1
+0
x
2
+\green7
x
4
+0
x
3
+?
x
5
=?	0
x
1
+0
x
2
 + ?
x
4
+0
x
3
+?
x
5
=?	0
x
1
+0
x
2
 + ?
x
4
+0
x
3
+?
x
5
=?

4.  If all the coefficients below and to the right of the element are equal to zero, you should find the non-zero element in the whole bottom-left part of the linear system regarding the current element. If such a coefficient is found in some row and column, you should swap both row and column so that this non-zero element appear in place of the current element. Also, don't forget to remember the column's swap. In the example below, rows 3 and 4 and columns 3 and 5 have been swapped.
⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1 + ?x2 + ?x3 + ?x4 + ?x5=?0x1+1x2 + ?x3 + ?x4 + ?x5=?0x1+0x2+0x3+0x4+0x5=?0x1+0x2+0x3 + \red?x4 + \red?x5=?0x1+0x2+0x3 + \red?x4 + \red?x5=?
{
1
x
1
 + ?
x
2
 + ?
x
3
 + ?
x
4
 + ?
x
5
=?	0
x
1
+1
x
2
 + ?
x
3
 + ?
x
4
 + ?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+0
x
4
+0
x
5
=?	0
x
1
+0
x
2
+0
x
3
 + \red?
x
4
 + \red?
x
5
=?	0
x
1
+0
x
2
+0
x
3
 + \red?
x
4
 + \red?
x
5
=?


⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1 + ?x2 + ?x3 + ?x4 + ?x5=?0x1+1x2 + ?x3 + ?x4 + ?x5=?0x1+0x2+0x3+0x4+0x5=?0x1+0x2+0x3 + ?x4+\green3x5=?0x1+0x2+0x3 + ?x4 + ?x5=?
{
1
x
1
 + ?
x
2
 + ?
x
3
 + ?
x
4
 + ?
x
5
=?	0
x
1
+1
x
2
 + ?
x
3
 + ?
x
4
 + ?
x
5
=?	0
x
1
+0
x
2
+0
x
3
+0
x
4
+0
x
5
=?	0
x
1
+0
x
2
+0
x
3
 + ?
x
4
+\green3
x
5
=?	0
x
1
+0
x
2
+0
x
3
 + ?
x
4
 + ?
x
5
=?


⎧⎩⎨⎪⎪⎪⎪⎪⎪⎪⎪⎪⎪1x1 + ?x2 + ?x5 + ?x4 + ?x3=?0x1+1x2 + ?x5 + ?x4 + ?x3=?0x1+0x2+\green3x5 + ?x4+0x3=?0x1+0x2+0x5+0x4+0x3=?0x1+0x2 + ?x5 + ?x4+0x3=?
{
1
x
1
 + ?
x
2
 + ?
x
5
 + ?
x
4
 + ?
x
3
=?	0
x
1
+1
x
2
 + ?
x
5
 + ?
x
4
 + ?
x
3
=?	0
x
1
+0
x
2
+\green3
x
5
 + ?
x
4
+0
x
3
=?	0
x
1
+0
x
2
+0
x
5
+0
x
4
+0
x
3
=?	0
x
1
+0
x
2
 + ?
x
5
 + ?
x
4
+0
x
3
=?


5. If there are no such elements in the whole bottom-left part of the linear system, you should end the first part of the algorithm.

After all the manipulations in the first half of the algorithm, check the possibility of no solutions. It is possible when there is a all-zero row and a constant is not equal to zero. You can see the example below. In this case, a linear system contains a contradiction and therefore have no solutions. In this case, you can end the algorithm.

⎧⎩⎨0...+0+...+0=bi,bi≠0...
{
...	0	+0+...+0=
b
i
,
b
i
≠0		...

Secondly, the linear system doesn't need to be an equal in amount variables and in amount of equations.

A number of significant equations are equal to the number of non-zero rows in the linear system. A number of significant variables are equal to the number of all columns in the linear system. After that, you can determine if the linear system has an infinite amount of solutions or a single one.

The following variants are possible:

1. The number of significant equations is equal to the number of significant variables. There is only one solution, you can find it like in the previous stage. The possible examples are shown below:

⎛⎝⎜⎜100210341562⎞⎠⎟⎟,⎛⎝⎜⎜⎜⎜⎜⎜10000310005210073100⎞⎠⎟⎟⎟⎟⎟⎟
(
1	2	3	5	0	1	4	6	0	0	1	2
)
,
(
1	3	5	7	0	1	2	3	0	0	1	1	0	0	0	0	0	0	0	0
)


2. The number of significant equations is less than the number of significant variables. There are infinitely many solutions. The possible examples are shown below:

(10314555),(10710015)
(
1	3	4	5	0	1	5	5
)
,
(
1	7	0	1	0	1	0	5
)

⎛⎝⎜⎜⎜⎜⎜⎜10000310005200073000⎞⎠⎟⎟⎟⎟⎟⎟,⎛⎝⎜⎜100410000620⎞⎠⎟⎟
(
1	3	5	7	0	1	2	3	0	0	0	0	0	0	0	0	0	0	0	0
)
,
(
1	4	0	6	0	1	0	2	0	0	0	0
)

Note that there can't be a case in which the number of significant equations is greater than the number of significant variables because in this case there would be a contradiction we handled in the previous steps of the algorithm.

In this stage you should write a program that handles all these nuances.

Write to file only No solutions or Infinitely many solutions when this appears to happen. If there is a single solution you should write to file only x1,x2,...,xn
x
1
,
x
2
,
.
.
.
,
x
n
, and every number should be on a separate line.

Don't forget that input can contain floating-point numbers.

You can refactor your code and work with a linear equation on a high level of abstraction - using Command pattern.

Example

Suppose you have a file named in.txt. It contains the following. Note that the first line contains the number of variables and the number of equations. So, in the following example, there are three variables, x1
x
1
, x2
x
2
, x3
x
3
 (remember, that last column is devoted to bi
b
i
 ) and four equations (number of equations is the number of rows).

3 4
0 1 2 9
0 1 3 1
1 0 6 0
2 0 2 0
 Input corresponds to the following equation:

⎧⎩⎨⎪⎪⎪⎪0∗x1+1∗x2+2∗x3=90∗x1+1∗x2+3∗x3=11∗x1+0∗x2+6∗x3=02∗x1+0∗x2+2∗x3=0
{
0∗
x
1
+1∗
x
2
+2∗
x
3
=9	0∗
x
1
+1∗
x
2
+3∗
x
3
=1	1∗
x
1
+0∗
x
2
+6∗
x
3
=0	2∗
x
1
+0∗
x
2
+2∗
x
3
=0

Below is how your program might work. The lines which start with > represent the user input.

> java Solver -in in.txt -out out.txt
Start solving the equation.
Rows manipulation:
R1 <-> R3
-2 * R1 + R4 -> R4
-1 * R2 + R3 -> R3
-1 * R3 -> R3
No solutions
Saved to file out.txt
And the file out.txt should look like this.

No solutions
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LinearSolution solution = new LinearSolution();
        File in = new File("src/main/java/hyperskill/projects/linear/stage5/in.txt");
        // File in = new File(args[1]);
        File out = new File("src/main/java/hyperskill/projects/linear/stage5/out.txt");
        // File out = new File(args[3]);
        solution.read(in);
        solution.solve();
        solution.write(out);
    }
}

class Matrix {
    private final List<Row> rows;

    Matrix() {
        this.rows = new ArrayList<>();
    }

    void add(Row row) {
        rows.add(row);
    }

    Row getRow(int index) {
        return rows.get(index);
    }

    void switchRow(int from, int to) {
        Row temp = rows.get(from);
        rows.set(from, rows.get(to));
        rows.set(to, temp);
    }

    void switchColumns(int from, int to) {
        rows.forEach(r -> r.switchRow(from, to));
    }

    OptionalInt findFirstNonZeroRow(int start) {
        return IntStream
                .range(start + 1, rows.size())
                .filter(i -> !rows.get(i).getColumn(start).equals((double) 0))
                .findFirst();
    }

    OptionalInt findFirstNonZeroInColumn(int start) {
        Row row = rows.get(start);
        return IntStream
                .range(start + 1, row.getAll().size())
                .filter(i -> !row.getColumn(i).equals((double) 0))
                .findFirst();
    }

    Optional<RowColHelper> findFirstNonZeroColRow(int start) {
        for (int row = start + 1; row < rows.size(); row++) {
            for (int col = start + 1; col < rows.get(row).size(); col++) {
                if (!rows.get(row).getColumn(col).equals((double) 0)) {
                    return Optional.of(new RowColHelper(row, col));
                }
            }
        }
        return Optional.empty();
    }

    public void update(int row, int index, double value) {
        rows.get(row).updateColumn(index, value);
    }

    public Double sumOfRow(int row) {
        return rows.get(row).getAll().stream().reduce((double) 0, Double::sum);
    }

    public Double sumOfDigonal(int numOfColumns) {
        return IntStream.range(0, numOfColumns).mapToDouble(row -> rows.get(row).getColumn(row)).sum();
    }
}

class Row {
    private final List<Double> row;

    Row() {
        this.row = new ArrayList<>();
    }

    public void updateColumn(int index, double value) {
        this.row.set(index, value);

    }

    void add(Double value) {
        row.add(value);
    }

    public Double getColumn(int index) {
        return row.get(index);
    }

    public List<Double> getAll() {
        return row;
    }

    int size() {
        return row.size();
    }

    void switchRow(int from, int to) {
        Double temp = row.get(from);
        row.set(from, row.get(to));
        row.set(to, temp);
    }

}

class Column {
    private final List<Integer> columns;

    Column(int howManyColumns) {
        columns = IntStream
                .rangeClosed(1, howManyColumns)
                .mapToObj(i -> +i)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> getColumns() {
        return columns;
    }

    void switchColumn(int from, int to) {
        int temp = columns.get(from);
        columns.set(from, columns.get(to));
        columns.set(to, temp);
    }

    int get(int index) {
        return columns.get(index);
    }

}

class Result {
    List<Double> result;

    Result() {
        result = new ArrayList<>();
    }

    void add(Double value) {
        result.add(value);
    }

    Double get(int index) {
        return result.get(index);
    }

    void switchResult(int from, int to) {
        Double temp = result.get(from);
        result.set(from, result.get(to));
        result.set(to, temp);
    }

    public void update(int index, double value) {
        result.set(index, value);

    }
}

class RowColHelper {
    private final int row;
    private final int column;

    public RowColHelper(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

class LinearSolution {
    private final Matrix matrix;
    private Column column;
    private final Result result = new Result();
    private String solution;
    int howManyColumns;
    int howManyEquations;

    public LinearSolution() {
        this.matrix = new Matrix();
    }

    void read(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        howManyColumns = scanner.nextInt();
        howManyEquations = scanner.nextInt();

        column = new Column(howManyColumns);
        for (int i = 0; i < howManyEquations; i++) {
            Row row = new Row();
            for (int j = 0; j < howManyColumns; j++) {
                row.add(scanner.nextDouble());
            }
            result.add(scanner.nextDouble());
            matrix.add(row);
        }
        scanner.close();

    }

    public void write(File file) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(file)) {
            System.out.println();
            System.out.println("The solution is: " + solution.replace("\n", ", "));
            writer.println(solution);
            System.out.println("Saved to file " + file.getAbsolutePath());
        }
    }

    void solve() {
        print();
        stage1();
        IntStream.range(0, howManyEquations).forEach(this::stage2);
        boolean noSolutions = false;
        for (int i = 0; i < howManyEquations; i++) {
            if (isNoSolutions(i)) {
                noSolutions = true;
                break;
            }
        }
        if (noSolutions) {
            solution = "No solutions";
        } else {
            int s = Math.min(howManyColumns, howManyEquations);
            for (int row = s - 1; row > 0; row--) {
                stage3(row);
            }
            if (matrix.sumOfDigonal(s).equals((double) howManyColumns)) {
                Map<Integer, Double> map = IntStream
                        .range(0, howManyColumns)
                        .collect(TreeMap::new, (m, i) -> m.put(column.get(i), result.get(i)), TreeMap::putAll);
                solution = map.values().stream().map(String::valueOf).collect(Collectors.joining("\n"));
            } else {
                solution = "Infinitely many solutions";
            }
        }
    }

    void stage1() {
        int s = Math.min(howManyColumns, howManyEquations);
        for (int i = 0; i < s; i++) {
            if (matrix.getRow(i).getColumn(i).equals((double) 0)) {
                OptionalInt findNext;
                if ((findNext = matrix.findFirstNonZeroRow(i)).isPresent()) {
                    matrix.switchRow(i, findNext.getAsInt());
                    result.switchResult(findNext.getAsInt(), i);
                    System.out.println("R" + (i + 1) + " <-> R" + (findNext.getAsInt() + 1));
                    print();
                } else if ((findNext = matrix.findFirstNonZeroInColumn(i)).isPresent()) {
                    matrix.switchColumns(i, findNext.getAsInt());
                    column.switchColumn(i, findNext.getAsInt());
                    System.out.println(column.get(findNext.getAsInt()) + " <-> " + column.get(i));
                    print();
                } else {
                    Optional<RowColHelper> optional = matrix.findFirstNonZeroColRow(i);
                    if (optional.isPresent()) {
                        int row = optional.get().getRow();
                        matrix.switchRow(i, row);
                        result.switchResult(i, row);
                        System.out.println("R" + (i + 1) + " <-> R" + (row));

                        int col = optional.get().getColumn();
                        matrix.switchColumns(i, col);
                        column.switchColumn(i, col);
                        System.out.println(column.get(col) + " <-> " + column.get(i));
                        print();
                    }
                }
            }
        }
    }

    void stage2(int row) {
        if (row < matrix.getRow(row).size()) {
            if (matrix.getRow(row).getColumn(row) != 0) {
                if (!matrix.getRow(row).getColumn(row).equals(1d)) {
                    Double k = matrix.getRow(row).getColumn(row);
                    result.update(row, result.get(row) / k);
                    IntStream
                            .range(row, matrix.getRow(row).size())
                            .forEach(i -> matrix.update(row, i, matrix.getRow(row).getColumn(i) / k));
                    System.out.println((1 / k) + " * R" + (row + 1) + " -> R" + (row + 1));
                    print();

                }
                IntStream.range(row + 1, howManyEquations).forEach(i -> {
                    double k = -matrix.getRow(i).getColumn(row);
                    if (k != 0) {
                        result.update(i, result.get(i) + k * result.get(row));
                        IntStream.range(row, matrix.getRow(row).size())
                                .forEach(j ->
                                        matrix.update(i, j, matrix.getRow(i).getColumn(j) + k * matrix.getRow(row).getColumn(j))
                                );
                        System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
                        print();
                    }
                });
            }
        }

    }

    void stage3(int row) {
        for (int i = row - 1; i >= 0; i--) {
            double k = -matrix.getRow(i).getColumn(row);
            if (matrix.getRow(row).getColumn(row) == 1) {
                result.update(i, result.get(i) + k * result.get(row));
                for (int col = howManyColumns - 1; col >= 0; col--) {
                    matrix.update(i, col, matrix.getRow(i).getColumn(col) + k * matrix.getRow(row).getColumn(col));
                }
                System.out.println(k + " * R" + (row + 1) + " + R" + (i + 1) + " -> R" + (i + 1));
                print();
            }

        }
    }

    private boolean isNoSolutions(int row) {
        return matrix.sumOfRow(row).equals((double) 0) && !result.get(row).equals((double) 0);
    }

    void print() {
        column.getColumns().forEach(c -> System.out.printf("  %s  ", c));
        System.out.printf("%s\n", "result");
        IntStream.range(0, howManyEquations).forEach(i -> {
            matrix.getRow(i).getAll().forEach(s -> System.out.printf("%.2f ", s));
            System.out.printf("%.2f\n", result.get(i));
        });
        System.out.println();
    }
}
