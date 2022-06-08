package com.repeat.submit.redis.config;

import com.repeat.submit.redis.filter.RepeatableFilter;
import com.repeat.submit.redis.interceptor.RepeatSubmitInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 防重复提交配置
 */
@Slf4j
@Configuration
public class RepeatSubmitConfig implements WebMvcConfigurer {

    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;
    /**
     * 添加防重复提交拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("-->WebMvcConfigurer配置启动....");
        //注册防止重复提交拦截器
        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }

    /**
     * 生成防重复提交过滤器（重写request）
     * @return FilterRegistrationBean
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean<?> createRepeatableFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RepeatableFilter());
        registration.addUrlPatterns("/*");
        registration.setName("repeatableFilter");
        registration.setOrder(FilterRegistrationBean.LOWEST_PRECEDENCE);
        return registration;
    }
}