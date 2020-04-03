package com.ycl.share.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 管理后台
 *
 */
@EnableFeignClients
@SpringBootApplication
public class BackendCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCenterApplication.class, args);
	}

}