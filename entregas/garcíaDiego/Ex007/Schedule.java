public enum Schedule {

    BREAKFAST (1, "Breakfast"),
    MIDMORNING (2, "Mid-Morning"),
    LAUNCH (3, "Launch"),
    SNACK (4, "Snack"),
    DINNER (5, "Dinner");

    private int code;
    private String description;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private Schedule(int code, String description) {
        this.code = code;
        this.description = description;
    }
    
    
}
