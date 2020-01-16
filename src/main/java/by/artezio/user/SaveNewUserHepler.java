package by.artezio.user;
import by.artezio.application.ApplicationService;
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

	 ApplicationUser prepareUser(String name, String email, String password, String userName,
			String url) {
		Set<ApplicationRole> roles = new HashSet<>();
		log.info("try to find default role");
		Long id = applicationService.findApplicationByUrl(url).getId();
		ApplicationRole defaultRole = roleService.getDefaultRole(id, "DEFAULT");
		log.info("role found!");
		roles.add(defaultRole);

		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setName(name);
		applicationUser.setEmail(email);
		applicationUser.setPassword(password);
		applicationUser.setLogin(userName);
		applicationUser.setRole(roles);
		return applicationUser;
	}
}
