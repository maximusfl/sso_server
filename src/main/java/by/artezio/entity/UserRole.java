package by.artezio.entity;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role")
public class UserRole  implements Serializable {

    @Id
    @Column(name = "user_id")

    private Long userId;

    @Id
    @Column(name = "role_id")

    private Long roleId;

    public UserRole() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
