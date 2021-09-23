package dev.spring.webcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration // Indica que una clase declara uno o m�s m�todos @Bean y puede ser procesada por el contenedor Spring para generar definiciones de beans y solicitudes de servicio para esos beans en tiempo de ejecuci�n.
@EnableWebMvc // Habilita la configuraci�n predeterminada de Spring MVC y registra los componentes de infraestructura de Spring MVC esperados por DispatcherServlet.
@ComponentScan(basePackages = { "dev.spring.webcrud" }) // Se utiliza para especificar los paquetes base a analizar. Cualquier clase que est� anotada con @Component y @Configuration ser� escaneada.
public class WebMvcConfig implements WebMvcConfigurer {
// WebMvcConfigurer define opciones para personalizar o agregar a la configuraci�n predeterminada de Spring MVC habilitada mediante el uso de @EnableWebMvc.

	@Bean
	// CONFIGURACI�N SPRING MVC DIRECTORIO VIEW (DE DONDE LEER� LAS VISTAS). LO MISMO QUE CONFIGURABA EN EL spring-servlet.xml
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Indicamos a Spring que no procese las rutas de recursos est�ticos.
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/cliente/list");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}
