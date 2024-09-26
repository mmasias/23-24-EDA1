public class Cell {

    private String content;

    public Cell(){
        this.content = null;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String formatCell() {
        if(content == null){
            return "       ";
        } else if (content.length() >= 7){

            return content.substring(0, 7);

        } else {
            int spacesToAdd = 7 - content.length();

            return content + " ".repeat(spacesToAdd);
        }
    }

}
