package by.artezio.user;

import by.artezio.application.ApplicationService;
import by.artezio.application.DomainNameExtractor;
import by.artezio.dto.user.RegisterUserFormDto;
import by.artezio.entity.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    SaveNewUserHepler userHelper;

    @GetMapping
    public ModelAndView showRegisterPage(HttpServletRequest request) {
        logger.info("called showRegisterPage");
        String urlBeforeRedirect = request.getHeader("referer");
        logger.info("urlBeforeRedirect: " + urlBeforeRedirect);
        return new ModelAndView("registration", "urlBeforeRedirect", urlBeforeRedirect);
    }

    @PostMapping
    public ModelAndView registrationUser(@Valid @ModelAttribute RegisterUserFormDto userFormDto,
                                         BindingResult bindingResult, HttpServletRequest request, HttpStatus status) {

        logger.info("content-type: " + request.getHeader("content-type"));

        if (bindingResult.hasErrors()) {
            request.setAttribute("message", "parametrs can't be empty");

            return new ModelAndView("registration", "urlBeforeRedirect", userFormDto.getUrlBeforeRedirect());
        }

        String domainName = extractor.extractDomainName(userFormDto.getUrlBeforeRedirect());

        if (applicationService.findApplicationByUrl(domainName) == null) {
            request.setAttribute("message", "this application hasn't been registered");
            return new ModelAndView("registration", "urlBeforeRedirect", userFormDto.getUrlBeforeRedirect());
        }

        if (userService.findByLogin(userFormDto.getUserName()) != null) {
            request.setAttribute("message", "login " + userFormDto.getUserName() + " is using already");
            return new ModelAndView("registration", "urlBeforeRedirect", userFormDto.getUrlBeforeRedirect());
        }
        if (userService.findByEmail(userFormDto.getEmail()) != null) {
            request.setAttribute("message", "email " + userFormDto.getEmail() + " is using already");
            return new ModelAndView("registration", "urlBeforeRedirect", userFormDto.getUrlBeforeRedirect());
        }
        logger.info("name: " + userFormDto.getName() + " email: " + userFormDto.getEmail() + " password: "
                + userFormDto.getPassword() + " userName: " + userFormDto.getUserName() + " domainName: " + domainName);

        ApplicationUser user = null;
        user = userHelper.prepareUser(userFormDto, domainName);

        if (user == null) {
            request.setAttribute("message",
                    "default role for " + domainName + " hasn't been set, contact to administrator");
            return new ModelAndView("registration", "urlBeforeRedirect", userFormDto.getUrlBeforeRedirect());
        } else {
            userService.addUser(user);
            request.setAttribute("success", "You have been registered!  Please, enter login and password.");
            return new ModelAndView("login", "urlBeforeRedirect", userFormDto.getUrlBeforeRedirect());
        }

    }

}
