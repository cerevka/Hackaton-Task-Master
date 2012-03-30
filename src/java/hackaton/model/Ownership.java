package hackaton.model;

import com.googlecode.objectify.Key;
import javax.persistence.Id;

public class Ownership {
    
    @Id
    private Long id;
    private OwnershipType type;
    private Key<User> user;
    private Key<Task> task;

    public Ownership(Long id, OwnershipType type, User user, Task task) {
        this.id = id;
        this.type = type;
        this.user = new Key<User>(User.class, user.getId());
        this.task = new Key<Task>(Task.class, task.getId());
    }
    
    private Ownership() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Key<Task> getTask() {
        return task;
    }

    public void setTask(Key<Task> task) {
        this.task = task;
    }

    public OwnershipType getType() {
        return type;
    }

    public void setType(OwnershipType type) {
        this.type = type;
    }

    public Key<User> getUser() {
        return user;
    }

    public void setUser(Key<User> user) {
        this.user = user;
    }
    
}
