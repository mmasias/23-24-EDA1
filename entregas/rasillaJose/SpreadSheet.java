public class SpreadSheet {
    public static String emthyCell = "       ";
    public static String[][] sheet = new String[15][10];

    public void buildSpreadSheet() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                sheet[i][j] = emthyCell;
            }
        }
    }


    public String getCell(int x, int y) {
        if (sheet[x][y] != null) {
            return sheet[x][y];
        } else
            return emthyCell;
    }

    public void setCell(int x, int y, String newContent) {
        sheet[x][y] = newContent;
    }

}
