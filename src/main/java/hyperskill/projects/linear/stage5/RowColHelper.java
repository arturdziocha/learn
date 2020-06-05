package hyperskill.projects.linear.stage5;

public class RowColHelper {
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
    @Override
    public String toString() {
        return "RowColHelper [row=" + row + ", column=" + column + "]";
    }
}
