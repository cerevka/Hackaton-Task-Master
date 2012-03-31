package hackaton.model;

import com.googlecode.objectify.Key;
import javax.persistence.Id;



public class OwnershipTag {
    
    @Id
    private Long id;
    private Key<Tag> tag;
    private Key<Ownership> ownership;

    public OwnershipTag(Long id, Key<Tag> tag, Key<Ownership> ownership) {
        this.id = id;
        this.tag = tag;
        this.ownership = ownership;
    }

    private OwnershipTag() {
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

    public Key<Tag> getTag() {
        return tag;
    }

    public void setTag(Key<Tag> tag) {
        this.tag = tag;
    }
    
}
