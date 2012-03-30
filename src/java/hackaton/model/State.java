package hackaton.model;

import javax.persistence.Id;

public class State {

    @Id
    private String name;

    private State() { }

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
