package by.artezio.configuration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class SsoServerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        context.register(JpaConfiguration.class);

        DispatcherServlet servlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic registration =
                servletContext.addServlet("dispatcher", servlet);

        registration.addMapping("/");
        registration.setLoadOnStartup(1);
    }
}
