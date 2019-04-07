package com.share.view.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class StockViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockViewerApplication.class, args);
	}

}
