package pl.krzysztofskul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pl.krzysztofskul.device.DeviceConverter;
import pl.krzysztofskul.device.prototype.PrototypeConverter;
import pl.krzysztofskul.email.EmailCredentials;
import pl.krzysztofskul.localDateTime.LocalDateTimeConverter;
import pl.krzysztofskul.localDateTime.LocalDateTimeConverterToString;
import pl.krzysztofskul.project.configuration.ConfigurationConverter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Locale;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.krzysztofskul")
@EnableJpaRepositories(basePackages = "pl.krzysztofskul")
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	EmailCredentials credentials;
	
    @Bean
    public ViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Bean(name="localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("pl","PL"));
        return localeResolver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] {"pl.krzysztofskul"});
        em.setJpaDialect(new HibernateJpaDialect());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "drop-and-create");
//        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.jdbc.time_zone", "UTC");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        /* local DB*/
        //dataSource.setUrl("jdbc:mysql://localhost:3306/smnsh?useSSL=false");
        dataSource.setUrl("jdbc:mysql://localhost:3306/smnsh?allowPublicKeyRetrieval=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("@xDpo9Ec16N7&OP0"); // randomly generated password for tests at localhost

        /* remote DB */
//        dataSource.setUrl("");
//        dataSource.setUsername(System.getProperty("RDS_USERNAME"));
//        dataSource.setPassword(System.getProperty("RDS_PASSWORD"));
        
        /* remote railway DB */
      dataSource.setUrl("jdbc:mysql://${PROD_DB_HOST}:${PROD_DB_PORT}/${PROD_DB_NAME}");
      dataSource.setUsername(System.getProperty("${PROD_DB_USERNAME}"));
      dataSource.setPassword(System.getProperty("${PROD_DB_PASSWORD}"));


        return dataSource;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry handlerRegistry) {
        handlerRegistry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DeviceConverter getDeviceConverter() {
        return new DeviceConverter();
    }

    @Bean
    public LocalDateTimeConverter getLocalDateTimeConverter() {
        return new LocalDateTimeConverter();
    }
    @Bean
    public LocalDateTimeConverterToString getLocalDateTimeConverterToString() {
        return new LocalDateTimeConverterToString();
    }
    @Bean
    public ConfigurationConverter getConfigurationConverter() {
    	return new ConfigurationConverter();
    }
    @Bean
    public PrototypeConverter getPrototypeConverter() {
    	return new PrototypeConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getDeviceConverter());
        registry.addConverter(getLocalDateTimeConverter());
        registry.addConverter(getLocalDateTimeConverterToString());
        registry.addConverter(getConfigurationConverter());
        registry.addConverter(getPrototypeConverter());
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        //EmailCredentials credentials = EmailCredentials.getEmailCredentialsInstance(); //This file is not added to Git. It contains login and password to the email client.

        mailSender.setHost("127.0.0.1");
        mailSender.setPort(1025);
        mailSender.setUsername(credentials.getLogin());
        mailSender.setPassword(credentials.getPass());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.from", credentials.getLogin());
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");//Prints out the log on the screen
        javaMailProperties.put("mail.smtp.ssl.trust", "*");

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
