package dev.spring.webcrud.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {
	// CONFIGURACIÓN QUE SUSTITUYE AL ARCHIVO web.xml
	// onStartup() será invocado automáticamente por el contenedor de servlets cuando se esté cargando la aplicación.
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		// Spring Dispatcher Servlet maneja todas las solicitudes a través de la asignación de URL
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}

