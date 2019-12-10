package by.artezio.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "applications")
@JsonIgnoreProperties(value= {"roles"})
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_url")
    private String appUrl;

    @Column(name = "application_name")
    private String appName;

    @Column(name = "application_description")
    private String description;

    @OneToMany( mappedBy = "application", fetch = FetchType.LAZY)
    @Column(nullable = true)
        private Set<ApplicationRole> roles;

    public Application(String appUrl, String appName, String description,  Set<ApplicationRole> roles) {
        this.appUrl = appUrl;
        this.appName = appName;
        this.description = description;
        this.roles = roles;
    }

    public Application() {
    }

    public Long getId() {
        return id;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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
