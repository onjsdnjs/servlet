package io.servlet.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan // WebServlet 사용을 위해 필요
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<LazyServlet> lazyServlet() {
        ServletRegistrationBean<LazyServlet> bean = new ServletRegistrationBean<>(new LazyServlet(), "/lazy-servlet");
//        bean.setLoadOnStartup(0);  // 요청이 올 때까지 로드 안 함
        return bean;
    }

    // EagerServlet: loadOnStartup(1) 설정 -> 서버 시작 시 즉시 로드
    @Bean
    public ServletRegistrationBean<EagerServlet> eagerServlet() {
        ServletRegistrationBean<EagerServlet> bean = new ServletRegistrationBean<>(new EagerServlet(), "/eager-servlet");
        bean.setLoadOnStartup(1);  // 서버 시작 시 로드됨
        return bean;
    }

}
