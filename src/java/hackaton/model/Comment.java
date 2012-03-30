package hackaton.model;

import com.googlecode.objectify.Key;
import java.util.Date;
import javax.persistence.Id;

public class Comment {

    @Id
    private Long id;
    private String text;
    private Date created;
    private Key<Ownership> ownership;
    private CommentType type;

    public Comment(Long id, String text, Date created, Ownership ownership, CommentType type) {
        this.id = id;
        this.text = text;
        this.created = created;
        this.ownership = new Key<Ownership>(Ownership.class, ownership.getId());
        this.type = type;
    }

    public Comment() {
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

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

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }
    
}
