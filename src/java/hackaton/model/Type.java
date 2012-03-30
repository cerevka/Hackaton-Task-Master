package hackaton.model;

import javax.persistence.Id;

class Type {

    @Id
    private String name;

    public Type(String name) {
        this.name = name;
    }

    private Type() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
