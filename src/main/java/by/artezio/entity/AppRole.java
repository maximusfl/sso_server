package by.artezio.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_role")
public class AppRole implements Serializable {

    @Id
    @Column(name = "app_id")

    private Long id;

    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_description")
    private String roleDescription;

    public AppRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
