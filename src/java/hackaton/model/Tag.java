package hackaton.model;

import com.googlecode.objectify.Key;
import javax.persistence.Id;

public class Tag {
    
    @Id
    private Long id;
    private String text;
    private Key<Ownership> ownership;
    private String color;

    public Tag(Long id, String text, Ownership ownership, String color) {
        this.id = id;
        this.text = text;
        this.ownership = new Key<Ownership>(Ownership.class, ownership.getId());
        this.color = color;
    }
    
    private Tag() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Key<Ownership> getOwnership() {
        return ownership;
    }

    public void setOwnership(Key<Ownership> ownership) {
        this.ownership = ownership;
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
