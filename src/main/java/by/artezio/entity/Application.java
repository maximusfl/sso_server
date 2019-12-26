package by.artezio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "applications")
@JsonIgnoreProperties(value = {"roles"})
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_url")
    private String applicationUrl;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "application_description")
    private String description;

    @OneToMany(mappedBy = "application", fetch = FetchType.LAZY)
    @Column(nullable = true)
    private Set<ApplicationRole> roles;

    public Application(String applicationUrl, String applicationName, String description, Set<ApplicationRole> roles) {
        this.applicationUrl = applicationUrl;
        this.applicationName = applicationName;
        this.description = description;
        this.roles = roles;
    }

    public Application() {
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public void setApplicationUrl(String appUrl) {
        this.applicationUrl = appUrl;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String appName) {
        this.applicationName = appName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ApplicationRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<ApplicationRole> roles) {
        this.roles = roles;
    }
}
