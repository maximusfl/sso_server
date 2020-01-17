package by.artezio.user;
import by.artezio.application.ApplicationService;
import by.artezio.application.DomainNameExtractor;
import by.artezio.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@RestController
@RequestMapping("/registration")
public class ApplicationUserRegisterController {
	private static Logger logger = Logger.getLogger("ApplicationUserRestController");

	@Autowired
	ApplicationUserService userService;
	@Autowired
	DomainNameExtractor extractor;
	@Autowired
	ApplicationService applicationService;
	@Autowired
	SaveNewUserHepler userHepler;

	@GetMapping
	public ModelAndView showRegisterPage(HttpServletRequest request) {
		logger.info("called showRegisterPage");
		String urlBeforeRedirect = request.getHeader("referer");
		logger.info("urlBeforeRedirect: "+ urlBeforeRedirect);
		return new ModelAndView("registration", "urlBeforeRedirect", urlBeforeRedirect);
	}

	@PostMapping
	public ModelAndView registrationUser(@RequestParam String name,
										 @RequestParam String password,
										 @RequestParam String urlBeforeRedirect,
										 @RequestParam String email,
										 @RequestParam String userName,
										 HttpServletRequest request){

		if(password == null || urlBeforeRedirect == null || email == null || userName == null){
			request.setAttribute("message", "parametrs can't be empty");
			return new ModelAndView("registration","urlBeforeRedirect", urlBeforeRedirect);
		}

		String domainName = null;
		if(!urlBeforeRedirect.isEmpty()){
			domainName = extractor.extractDomainName(urlBeforeRedirect);
		}

		if(applicationService.findApplicationByUrl(domainName) == null){
			request.setAttribute("message", "this application hasn't been registered");
			return new ModelAndView("registration","urlBeforeRedirect", urlBeforeRedirect);
		}

		if(password.isEmpty() || urlBeforeRedirect.isEmpty() || email.isEmpty() || userName.isEmpty()){
			request.setAttribute("message", "parametrs can't be empty");
			return new ModelAndView("registration","urlBeforeRedirect", urlBeforeRedirect);
		}

		if(userService.findByLogin(userName) != null){
			request.setAttribute("message", "login "+userName+" is been using already");
			return new ModelAndView("registration","urlBeforeRedirect", urlBeforeRedirect);
		}
		if(userService.findByEmail(email) != null){
			request.setAttribute("message", "email "+userName+" is been using already");
			return new ModelAndView("registration","urlBeforeRedirect", urlBeforeRedirect);
		}
		logger.info("name: "+name+
		"email: "+email+" password: "+password+" userName: " +userName+" domianName: "+ domainName);
		ApplicationUser user = null;
		user = userHepler.prepareUser(name,email,password,userName,domainName);

		if(user == null){
			request.setAttribute("message", "default role for "+domainName+" has not been set, contact to administrator");
			return new ModelAndView("registration","urlBeforeRedirect", urlBeforeRedirect);
		}
		else {
			userService.addUser(user);
			request.setAttribute("success", "You have been registered! Enter login and password!");
			return new ModelAndView("login", "urlBeforeRedirect", urlBeforeRedirect);
		}

	}

}
