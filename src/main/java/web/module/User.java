package web.module;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private boolean personWatchedTheSupernatural;

    public User() {}

    public User(String name, String surname, boolean personWatchedTheSupernatural) {
        this.name = name;
        this.surname = surname;
        this.personWatchedTheSupernatural = personWatchedTheSupernatural;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Boolean getPersonWatchedTheSupernatural( ) {
        return personWatchedTheSupernatural;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPersonWatchedTheSupernatural(boolean watchedTheSupernatural) {
        this.personWatchedTheSupernatural = watchedTheSupernatural;
    }

}
