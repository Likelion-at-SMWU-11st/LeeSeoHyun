package com.example.crud;
import com.example.crud.interceptor.HeaderLoggingInterceptor;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.annotation.PostConstruct;
import java.util.List;
@Configuration
public class DemoConfig implements WebMvcConfigurer {
    public static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    private final HeaderLoggingInterceptor headerLoggingInterceptor;

    public DemoConfig(@Autowired HeaderLoggingInterceptor headerLoggingInterceptor){
        this.headerLoggingInterceptor = headerLoggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(headerLoggingInterceptor)
        .addPathPatterns("/post/**")
        .excludePathPatterns("/except/**");
    }
//    @Value("${custom.property.single}")
//    private String customProperty;
//
//    @Value("${custom.property.comlist}")
//    private List<String> customCommaList;
//
//    @PostConstruct
//    public void init(){
//        logger.info("custom property: {}", customProperty);
//
//        for (String commaListItem: customCommaList){
//            logger.info("comma list item: {}", commaListItem);
//        }
//    }
//
//    @Bean
//    public Gson gson(){
//        return new Gson();
//    }
}





