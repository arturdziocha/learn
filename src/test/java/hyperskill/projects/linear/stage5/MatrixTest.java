package hyperskill.projects.linear.stage5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.OptionalInt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatrixTest {
    private Matrix matrix;

    @Test
    @DisplayName("Should switch row when find first non zero row in column")
    void test1() {
        // Given
        String[][] arr = { { "1", "-1.5-1.1i", "2.12" }, { "-1+3i", "1.2 -3.3", "1+15i" },
                { "12.31", "1.3-5i", "12.3i" } };
        matrix = new Matrix();
        for (String[] row : arr) {
            Row r = new Row();
            for (String col : row) {
                r.add(ComplexNumber.parse(col));
            }
            matrix.add(r);
        }

        OptionalInt find = matrix.findNonZeroRow(0);
        assertTrue(find.isPresent());
        assertEquals(1, find.getAsInt());
        matrix.switchRow(0, find.getAsInt());
        assertEquals(matrix.getRow(0).getColumn(0), ComplexNumber.parse("-1+3i"));
    }

    @Test
    @DisplayName("Should switch column when find first non zero column in row")
    void test2() {
        // Given
        String[][] arr = { { "1", "-1.5-1.1i", "2.12+3i" }, { "3i", "1.2 -3.3", "1+15i" },
                { "12.31", "1.3-5i", "12.3i" } };
        matrix = new Matrix();
        for (String[] row : arr) {
            Row r = new Row();
            for (String col : row) {
                r.add(ComplexNumber.parse(col));
            }
            matrix.add(r);
        }

        OptionalInt find = matrix.findFirstNonZeroInColumn(0);
        assertTrue(find.isPresent());
        assertEquals(1, find.getAsInt());
        matrix.switchColumns(0, find.getAsInt());
        assertEquals(matrix.getRow(0).getColumn(0), ComplexNumber.parse("-1.5-1.1i"));
    }

    @Test
    @DisplayName("Should switch row and column when find first non zero number in next row and column")
    void test3() {
        // Given
        String[][] arr = { { "1", "-1.5", "2.12" }, { "3i", "1.2-3.3", "1+15i" }, { "12.31", "1.3-5i", "12.3i" } };
        matrix = new Matrix();
        for (String[] row : arr) {
            Row r = new Row();
            for (String col : row) {
                r.add(ComplexNumber.parse(col));
            }
            matrix.add(r);
        }

        Optional<RowColHelper> find = matrix.findFirstNonZeroColRow(0);
        assertTrue(find.isPresent());
        assertEquals(1, find.get().getRow());
        matrix.switchRow(0, find.get().getRow());
        matrix.switchColumns(0, find.get().getColumn());
        assertEquals(matrix.getRow(0).getColumn(0), ComplexNumber.parse("1.2-3.3"));

    }

}
