package dev.spring.webcrud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration // Indica que una clase declara uno o más métodos @Bean y puede ser procesada por el contenedor Spring para generar definiciones de beans y solicitudes de servicio para esos beans en tiempo de ejecución.
@EnableTransactionManagement // Habilita la capacidad de gestión de transacciones impulsada por anotaciones de Spring.
public class HibernateConfig {

	@Autowired
    private ApplicationContext context;
 
    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        factoryBean.setAnnotatedPackages("dev.spring.webcrud.entity");
        return factoryBean;
    }
 
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}