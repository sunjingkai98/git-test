package com.intouch;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@MapperScan({"com.intouch.dao"})
public class SpringbootDangdangApplication {

    //创建durid连接池，并实施字面值注入
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource duridPool(){
        DataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    //注册servlet,提供监控页面，查看连接池页面视图
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initparams = new HashMap<>();
        initparams.put("loginUsername","admin");
        initparams.put("loginPassword","123456");
        servletRegistrationBean.setInitParameters(initparams);
        return servletRegistrationBean;
    }

    //注册过滤器，目的收集请求信息
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String,String> initparams = new HashMap<>();
        initparams.put("exclusions","*.css,*.js,*.png,*.gif,*.jpg,*.ico,*.jsp,/druid/*");
        filterRegistrationBean.setInitParameters(initparams);
        return filterRegistrationBean;
    }

    //打包修改
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        builder.sources(SpringbootDangdangApplication.class);
        return builder;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDangdangApplication.class, args);
    }

}
