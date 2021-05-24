package com.example.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NativeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NativeApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
	}

}
