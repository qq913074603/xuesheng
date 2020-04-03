package com.ycl.share.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>Description: [对静态资源的访问]</p>
 * Created on 2020/1/7
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2020 北京柯莱特科技有限公司
 */
@Configuration
public class ReactWebAppConfig implements WebMvcConfigurer {

	/**
	 * 添加静态资源文件，外部可以直接访问地址
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**", "classpath:/static/", "/images/**")
				.addResourceLocations("file:D:/images/");
	}
}
