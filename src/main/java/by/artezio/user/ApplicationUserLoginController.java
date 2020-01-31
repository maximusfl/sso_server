package by.artezio.user;

import by.artezio.application.DomainNameExtractor;
import by.artezio.entity.ApplicationUser;
import by.artezio.entity.Session;
import by.artezio.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/login")
public class ApplicationUserLoginController {
    @Autowired
    SessionService sessionService;

    @Autowired
    ApplicationUserService userService;
    private static Logger logger = Logger.getLogger("ApplicationUserLoginController");

    @GetMapping
    public ModelAndView showLoginPage(HttpServletRequest request) {

        logger.info("called showLoginPage");
        Optional<String> urlBeforeRedirect;
        logger.info("Optional<String> urlBeforeRedirect;");
        urlBeforeRedirect = Optional.ofNullable(request.getHeader("referer"));
        logger.info("urlBeforeRedirect = Optional.of(request.getHeader(\"referer\"));");
        if (!urlBeforeRedirect.isPresent()&& urlBeforeRedirect.isEmpty()){
            return new ModelAndView("error","message","Error: application is undefind!");
        }
        logger.info("urlBeforeRedirect: " + urlBeforeRedirect);
        return new ModelAndView("login", "urlBeforeRedirect", urlBeforeRedirect);

    }

    @PostMapping
    public ModelAndView login(@RequestParam String login, @RequestParam String password,
                              @RequestParam String urlBeforeRedirect, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("called login method");
        if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
            request.setAttribute("message", "login and password can't be empty");
            return new ModelAndView("login", "urlBeforeRedirect", urlBeforeRedirect);
        }

        if (urlBeforeRedirect == null) {
            logger.info("called DomainNameExtractor because urlBeforeRedirect in url was null; ");
            DomainNameExtractor extractor = new DomainNameExtractor();
            urlBeforeRedirect = extractor.extractDomainName(request.getContextPath());
            logger.info("urlBeforeRedirect: " + urlBeforeRedirect);

        }

        ApplicationUser loadedUser = userService.findByLogin(login);
        if (loadedUser != null) {
            logger.info("user was loaded");
            if (loadedUser.getPassword().equals(password)) {
                logger.info("password is the same");
                // создаём новую сессию сохраняем её в базу и редиректим на урлбефоредирект
                Session session = new Session();
                session.setCreationTime(new Date());
                session.setUser(loadedUser);
                session.setId(request.getSession().getId());
                sessionService.addSession(session);
                logger.info("urlBeforeRedirect: "+urlBeforeRedirect);
                response.sendRedirect(urlBeforeRedirect);
            }
        }
        request.setAttribute("urlBeforeRedirect", urlBeforeRedirect);
        return new ModelAndView("login", "message", "login or password incorrect");
    }


}
