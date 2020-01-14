package by.artezio.controller;

import by.artezio.dto.user.RegisterUserToFormDto;
import by.artezio.user.ApplicationUserRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/testRedireckt")
public class Test {
    private static Logger logger = Logger.getLogger(Test.class.getName());

    @GetMapping
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("called test");
        RegisterUserToFormDto user = new RegisterUserToFormDto();
        user.setUrlBeforeRedirect(request.getHeader("referer"));
        request.setAttribute("user",user);

        response.sendRedirect("registration");
        return new ModelAndView("registration");
    }

}
