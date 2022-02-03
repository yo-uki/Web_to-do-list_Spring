package learnprogramming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "rozdzielca";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("Witam Tomcat i wszystko inne");

        // create the spring application context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        //create the dispatcher servlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        //register and configure dispatcher servlet
        ServletRegistration.Dynamic rejestracja =
                servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        rejestracja.setLoadOnStartup(1);
        rejestracja.addMapping("/");
    }
}
