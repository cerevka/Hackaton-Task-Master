
package hackaton.model;

import com.googlecode.objectify.Key;
import java.util.Date;
import javax.persistence.Id;

public class Task {
    
    @Id
    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private int progress;
    private Date dateCreated;
    private Date deadline;
    private Key<State> state;
    private Key<Type> type;
    
    public Task(Long id, String title, String description, Priority priority, int progress, Date dateCreated, Date deadline, State state, Type type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.progress = progress;
        this.dateCreated = dateCreated;
        this.deadline = deadline;
        this.state = new Key<State>(State.class, state.getName());
        this.type = new Key<Type>(Type.class, type.getName());
    }

    private Task() { }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Key<State> getState() {
        return state;
    }

    public String getStateName() {
        return state.getName();
    }

    public String getTypeName() {
        return type.getName();
    }

    public void setState(Key<State> state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Key<Type> getType() {
        return type;
    }

    public void setType(Key<Type> type) {
        this.type = type;
    }
 
}
