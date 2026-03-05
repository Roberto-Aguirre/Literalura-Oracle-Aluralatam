package com.literalura.rias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.literalura.rias.controllers.HttpController;

@SpringBootApplication
public class RiasApplication {
	public static void main(String[] args) {
		var context = SpringApplication.run(RiasApplication.class, args);
		HttpController httpController = context.getBean(HttpController.class);
		httpController.getInfo("El Quijote");
	}
}
