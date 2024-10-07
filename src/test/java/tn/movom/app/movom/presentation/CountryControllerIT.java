package tn.movom.app.movom.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;
import tn.movom.app.infra.model.payload.ApiPayload;

import java.time.Instant;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CountryControllerIT {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@Value("${movom.api-version}")
	private String apiVersion;
	
	@Test
	void whenFindAllCountries_thenAllCountriesShouldReturn() {
		this.webTestClient
				.get()
				.uri(this.apiVersion + "/countries")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").value(notNullValue(ApiPayload.class))
				.jsonPath("$.timestamp").value(notNullValue(Instant.class))
				.jsonPath("$.status").value(notNullValue(ApiPayload.ApiStatus.class))
				.jsonPath("$.status").value(is(ApiPayload.ApiStatus.SUCCESS.name()))
				.jsonPath("$.total").value(notNullValue(Integer.class))
				.jsonPath("$.body").value(notNullValue())
				.jsonPath("$.body").isNotEmpty()
				.jsonPath("$.body").isArray();
	}
	
}



