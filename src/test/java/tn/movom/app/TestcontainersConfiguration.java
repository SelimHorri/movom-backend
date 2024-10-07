package tn.movom.app;

import org.springframework.boot.devtools.restart.RestartScope;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {
	
	private static final String POSTGRES_IMAGE = "postgres:16-alpine";
	//private static final String ZIPKIN_IMAGE = "openzipkin/zipkin:3.4";
	
	@Bean
	@ServiceConnection
	@RestartScope
	PostgreSQLContainer<?> postgresContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse(POSTGRES_IMAGE));
	}
	
	/*
	@Bean
	@ServiceConnection(name = "openzipkin/zipkin")
	@RestartScope
	GenericContainer<?> zipkinContainer() {
		return new GenericContainer<>(DockerImageName.parse(ZIPKIN_IMAGE)).withExposedPorts(9411);
	}
	*/
	
}



