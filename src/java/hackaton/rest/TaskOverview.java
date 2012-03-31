package hackaton.rest;

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
    
    public TaskOverview(String title, String description, String type, String state, String url, int progress) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.state = state;
        this.url = url;
        this.progress = progress;
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
        
}
