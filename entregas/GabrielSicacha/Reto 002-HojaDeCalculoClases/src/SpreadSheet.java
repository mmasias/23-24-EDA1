import java.util.Arrays;

public class SpreadSheet {
    int[] pos;
    int rows;
    int columns;
    String[][] spreadSheet;

    public SpreadSheet(int rows,  int columns) {
        this.pos = new int[] {0,0};
        this.rows = rows;
        this.columns = rows;
        this.spreadSheet = new String[rows][columns];
        for (String[] strings : spreadSheet) {
            Arrays.fill(strings, " ");
        }
    }
}
