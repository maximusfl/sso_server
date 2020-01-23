package by.artezio.user;

import by.artezio.application.ApplicationService;
import by.artezio.dto.user.RegisterUserFormDto;
import by.artezio.entity.ApplicationRole;
import by.artezio.entity.ApplicationUser;
import by.artezio.role.ApplicationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class SaveNewUserHepler {
    private static Logger log = Logger.getLogger("SaveNewUserHepler");
    @Autowired
    ApplicationRoleService roleService;

    @Autowired
    ApplicationService applicationService;

    ApplicationUser prepareUser(RegisterUserFormDto userFormDto, String url) {
        ApplicationUser applicationUser = null;
        Set<ApplicationRole> roles = new HashSet<>();
        log.info("try to find default role");
        Long id = applicationService.findApplicationByUrl(url).getId();
        ApplicationRole defaultRole;
        defaultRole = roleService.getDefaultRole(id, "DEFAULT");
        if (defaultRole != null) {
            log.info("role found! name: " + defaultRole.getRoleName());
            roles.add(defaultRole);
            applicationUser = new ApplicationUser();
            applicationUser.setName(userFormDto.getName());
            applicationUser.setEmail(userFormDto.getEmail());
            applicationUser.setPassword(userFormDto.getPassword());
            applicationUser.setLogin(userFormDto.getUserName());
            applicationUser.setRole(roles);

        }
        return applicationUser;
    }
}
