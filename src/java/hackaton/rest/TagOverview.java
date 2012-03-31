package hackaton.rest;

public class TagOverview {
    
    
       
    private String text;
    private String color;

    public TagOverview(String text, String color) {
        this.text = text;
        this.color = color;
    }
    
    public String getId() {
        return "1";
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
