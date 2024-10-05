/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dv.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dv.formatters.TaiXeFormatter;
import com.dv.formatters.TuyenXeFormatter;
import com.dv.formatters.XeFormatter;
import com.dv.pojo.TuyenXe;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author ADMIN
 */
@Configuration //Thành rỗ đậu
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.dv.controllers",
    "com.dv.repositories",
    "com.dv.services"
})
public class WebApplicationContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver r = new InternalResourceViewResolver();
//        r.setPrefix("/WEB-INF/pages/");
//        r.setSuffix(".jsp");
//        return r;
//    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public MessageSource messageSource() {//Chỉ cho vị trí đọc file properties
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasename("messages");//File message
        return m;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());//Truyền file để đọc
        return bean;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd'T'HH:mm"));

        registry.addFormatter(new TuyenXeFormatter());
        registry.addFormatter(new TaiXeFormatter());
        registry.addFormatter(new XeFormatter());

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Cho phép từ frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức được phép
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary;
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dizsmwu7t",
                "api_key", "631536123377314",
                "api_secret", "GGxJ5VeCXoVshTkbsGphdyhGbr4",
                "secure", true));
        return cloudinary;
    }

}
