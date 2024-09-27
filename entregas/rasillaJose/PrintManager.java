public class PrintManager{

    public static String rowTitles(int row){if(row<=9) {return "| 0" + row +" ";} else return "| " + row +" ";}
    public static String dividers = "|";


    public static void printHeader(){
        System.out.print("#----");
        for (int i = 0; i < 10; i++){
            System.out.print("|---------");
        }
        System.out.println("#");
    }

    public static void printSpreadSheet(int x, int y,SpreadSheet spreadSheet) { 
        printHeader();
        System.out.print("|    ");
        for (int i = 0; i < 10; i++){
            System.out.print("|    " + getColumnLetter(i) + "    ");
        }
        System.out.println("|");
        printHeader();


        for (int i = 0; i < 15; i++) {
            System.out.print(rowTitles(i + 1));
            for (int j = 0; j < 10; j++) {
                String extendedCell = spreadSheet.getCell(i, j) + "       ";
                String cellToPrint = extendedCell.substring(0, 7);
                if (!isSelected(i, j,x,y)) {
                    System.out.print(dividers + " " + cellToPrint + " ");
                } else {
                    System.out.print(dividers + "[" + cellToPrint + "]");
                }
            }
            System.out.print(dividers);
            System.out.println("");
        }
        printHeader();
        printCurrentCell(x,y,spreadSheet);
    }

    public static void printCurrentCell(int x, int y,SpreadSheet spreadSheet) {
        String cellPosition = String.valueOf(getColumnLetter(y)) + (x+1); 
        String cellContent = spreadSheet.getCell(x, y);
        String emthyCell = "";
        String printedContent = cellContent!= null ? cellContent : emthyCell;
        System.out.println(cellPosition + ": " + printedContent);
    }

    public static void printInstructions() {
        System.out.println("Use e to modify celll");
        System.out.println("Use WASD to move");
        System.out.println("Use x to exit");
    }

    public static void printModifyInstructions(){
        System.out.println("Type the new content (Only 7 characters will be printed)");
    }

    public static void printCloseMessage(){
        System.out.println("Closing program...");
    }

    public static void printConstructionMessage(){
        System.out.println("Spreadsheet V2.0 Inicialization!");
    }

    public static void printWrongInput(){
        System.out.println("That's not an allowed input!");
    }

    public static char getColumnLetter(int index){
        char character = (char) (65 + index);
        return character;
    }


    public static boolean isSelected(int x, int y, int currentX, int currentY) {
        if (x == currentX && y == currentY) {
            return true;
        }
        return false;
    }

}
