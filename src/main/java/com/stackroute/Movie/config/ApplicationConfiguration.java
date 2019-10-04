//package com.stackroute.Movie.config;
//
//
//import com.stackroute.Movie.model.Movie;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Profile;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//import org.springframework.core.env.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import springfox.documentation.service.Contact;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//
////import org.h2.server.web.WebServlet;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.Properties;
//
//
//@Configuration
//@EnableSwagger2
//@EnableTransactionManagement
//public class ApplicationConfiguration {
//
//    //this is for h2 console to view the tables in web
//    // to access this type localhost:8080/console in your browser
//    @Bean
//    ServletRegistrationBean servletRegistrationBean()
//    {
//        ServletRegistrationBean servletRegistrationBean= new ServletRegistrationBean(new WebServlet());
//        servletRegistrationBean.addUrlMappings("/console/*");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select().apis(RequestHandlerSelectors.basePackage("com.stackroute"))
//                .paths(PathSelectors.regex("/api.*"))
//                .build().apiInfo(metaData());
//    }
//
//    private ApiInfo metaData() {
//        ApiInfo apiInfo = new ApiInfo(
//                "Spring Boot REST API",
//                "Spring Boot REST API for Movie App",
//                "1.0",
//                "Terms of service",
//                new Contact("Barun Sarraf", "https://stackroute.com", "barunsaraf1@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses/LICENSE-2.0");
//        return apiInfo;
//    }
//
//    //uncomment this too while using value based annotation injection in application context
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
//    {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//}
