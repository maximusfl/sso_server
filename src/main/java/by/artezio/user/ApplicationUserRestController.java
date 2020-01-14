package by.artezio.user;

import by.artezio.dto.user.RegisterUserToFormDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

@RestController
@RequestMapping("/registration")
public class ApplicationUserRestController {
	private static Logger logger = Logger.getLogger("ApplicationUserRestController");

	@GetMapping
	public ModelAndView showRegisterPage(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer url = request.getRequestURL();
		logger.info("called registrationUser");
		logger.info("url: " + url);

		// Enumeration<String> headerNames = request.getHeaderNames();
		// List<String> list = Collections.list(headerNames);
		// for (String s : list) {
		// logger.info("header: " + s);
		// }
		// Map<String, String> map = new HashMap<String, String>();
		// Enumeration allHeaderNames = request.getHeaderNames();
		// while (allHeaderNames.hasMoreElements()) {
		// String key = (String) allHeaderNames.nextElement();
		// String value = request.getHeader(key);
		// map.put(key, value);
		// }
		// for (String s : map.keySet()) {
		// logger.info(s + " : " + map.get(s));
		// }
		RegisterUserToFormDto user = new RegisterUserToFormDto();
		user.setUrlBeforeRedirect(request.getHeader("referer"));
		logger.info("user's url: " + user.getUrlBeforeRedirect());
		request.setAttribute("showRegForm", "true");

		return new ModelAndView("registration", "user", user);
	}

	@PostMapping
	public void registrationUser(HttpServletRequest request, HttpServletResponse response,
								 @RequestParam String name,
								 @RequestParam String email,
								 @RequestParam String passwd) {
		StringBuffer url = request.getRequestURL();
		logger.info("called registrationUser");
		logger.info("url from redirect: " + url);
		logger.info("user_name: " + name+" email: "+email+"pass: "+passwd);

	}

}
