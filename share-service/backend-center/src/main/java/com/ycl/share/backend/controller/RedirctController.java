package com.ycl.share.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Description: [类功能描述]</p>
 * Created on 2020/1/7
 *
 * @author <a href="mailto: xienan@camelotchina.com">谢楠</a>
 * @version 1.0
 * Copyright (c) 2020 北京柯莱特科技有限公司
 */
@Slf4j
@Controller
public class RedirctController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "page/login/login";
	}

	/**
	 * 主页
	 * @return
	 */
	@GetMapping("/page/main")
	public String main() {
		return "page/main";
	}

	/**
	 * 通用跳转
	 * @param url
	 * @return
	 */
	@GetMapping("/sys/redirctUrl")
	public String redirctUrl(@RequestParam(name = "url") String url) {
		log.info("\n 本次跳转的页面: {}", url);
		return url;
	}

}
