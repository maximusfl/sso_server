package by.artezio.role;

import by.artezio.entity.ApplicationRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class ApplicationRoleService {
    private static Logger logger = Logger.getLogger("ApplicationRoleService");
    @Autowired
    ApplicationRoleDAO roleDAO;

    public void addRole(ApplicationRole role) {
        roleDAO.save(role);
    }

    public ApplicationRole findRoleById(Long id) {
        return roleDAO.findOne(id);
    }

    public void deleteRoleById(Long id) {
        roleDAO.delete(id);
    }

    public void deleteAllRoles() {
        roleDAO.deleteAll();
    }

    public List<ApplicationRole> getAllRoles() {
        return roleDAO.findAll();
    }

    public List<ApplicationRole> getRolesByApplication(Long id) {
        return roleDAO.getApplicationRolesByApplicationID(id);
    }

    public void update(ApplicationRole role) {
        roleDAO.save(role);
    }

    public ApplicationRole getDefaultRole(Long id, String roleName) {
        return roleDAO.findApplicationRoleByApplication_IdAndRoleName(id, roleName);
    }

    public List<ApplicationRole> findUserRolesByUserIdAndApplicationId(Long id, Long userId) {
        return roleDAO.findApplicationRolesByApplicationAndUser(id,userId);
    }

    public void deleteRoleFromUserByApplication(Long roleId, Long userId) {
        logger.info("called deleteRoleFromUserByApplication");

        logger.info("deleteApplicationRoleByApplicationAndAndUser has been worked already");

    }
}
