package src;

public interface IFuncionalidades {

    public void startingExcel(String[][] excel);

    public boolean processCommand(char command, String[][] excel, int[] position);

    public void insertText(String[][] page, int currentRow, int currentColumn);

    public void moving(int row, int column);
}