package hackaton.model;

import com.googlecode.objectify.Key;
import javax.persistence.Id;

public class Tag {
    
    @Id
    private Long id;
    private String text;
    private String color;
    private Key<User> owner;

    public Tag(Long id, String text, String color, User owner) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.owner = new Key<User>(User.class, owner.getId());
    }
    
    private Tag() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Key<User> getOwner() {
        return owner;
    }

    public void setOwner(Key<User> owner) {
        this.owner = owner;
    }
        
}
