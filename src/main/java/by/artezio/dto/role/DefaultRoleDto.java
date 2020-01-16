package by.artezio.dto.role;

import org.springframework.stereotype.Component;

@Component
public class DefaultRoleDto {
    public String roleName;
    public String roleDescription;

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
