package it.epicode.pizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzeriaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzeriaApplication.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(PizzeriaApplication.class);

		Menu m = (Menu) ctx.getBean("menu");

		m.printMenu();
		ctx.close();

	}

}
