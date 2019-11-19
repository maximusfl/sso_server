package by.artezio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "application_users")
public class ApplicationUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinColumn
    private Set<ApplicationRole> role;

    @OneToMany(mappedBy = "user")
    private Set<Session> session;

    public ApplicationUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<ApplicationRole> getRole() {
        return role;
    }

    public void setRole(Set<ApplicationRole> role) {
        this.role = role;
    }

    public Set<Session> getSession() {
        return session;
    }

    public void setSession(Set<Session> session) {
        this.session = session;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
