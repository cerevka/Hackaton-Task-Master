package hackaton.rest;

import hackaton.model.Priority;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomáš Čerevka <tomas@cerevka.cz>
 */
public class TaskOverview {

    private String title;
    private String description;
    private String type;
    private String state;
    private String url;
    private int progress;
    private Priority priority;
    private List<TagOverview> tags = new ArrayList<TagOverview>();

    public TaskOverview(String title, String description, String type, String state, String url, int progress, Priority priority) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.state = state;
        this.url = url;
        this.progress = progress;
        this.priority = priority;
    }
    
    public TaskOverview(String title, String description, String type, String state, String url, int progress, Priority priority, List<TagOverview> tags) {
        this(title, description, type, state, url, progress, priority);
        this.tags = tags;
    }

    public int getProgress() {
        return progress;
    }

    public String getState() {
        return state;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public List<TagOverview> getTags() {
        return tags;
    }

    public Priority getPriority() {
        return priority;
    }
    
    
}
