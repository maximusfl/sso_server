package by.artezio.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "applications_roles")
public class ApplicationRole implements Serializable {

    public ApplicationRole(Application application, String roleNmae, String roleDescription, Set<ApplicationUser> user) {
        this.application = application;
        this.roleNmae = roleNmae;
        this.roleDescription = roleDescription;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = true)
    private Application application;

    @Column(name = "role_name", nullable = false)
    private String roleNmae;

    @Column(name = "role_description")
    private String roleDescription;

    @ManyToMany(mappedBy = "role")
    private Set<ApplicationUser> user;

    public ApplicationRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getRoleNmae() {
        return roleNmae;
    }

    public void setRoleNmae(String roleNmae) {
        this.roleNmae = roleNmae;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Set<ApplicationUser> getUser() {
        return user;
    }

    public void setUser(Set<ApplicationUser> user) {
        this.user = user;
    }
}
