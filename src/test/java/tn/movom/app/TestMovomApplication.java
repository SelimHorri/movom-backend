package tn.movom.app;

import org.springframework.boot.SpringApplication;

public class TestMovomApplication {

	public static void main(String[] args) {
		SpringApplication.from(MovomApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
