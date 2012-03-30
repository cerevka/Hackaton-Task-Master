package hackaton.model;

import javax.persistence.Id;

public class User {
    
    @Id
    private Long id;
    private String firstname;
    private String surname;
    private Role role;
    private String email;
    private String comment;

    public User(Long id, String firstname, String surname, String email, String comment, Role role) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.comment = comment;
        this.role = role;
    }

    private User() { }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String name) {
        this.firstname = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}
