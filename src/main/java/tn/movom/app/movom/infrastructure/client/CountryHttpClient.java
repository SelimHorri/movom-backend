package tn.movom.app.movom.infrastructure.client;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface CountryHttpClient {
	
	@GetExchange
	ResponseEntity<CountryData> findCountryDetailsByName(@PathVariable("country") String name);
	
}

@JsonNaming(SnakeCaseStrategy.class)
record CountryData(String name,
				   String fullName,
				   String capital,
				   String iso2,
				   String iso3,
				   String currentPresident,
				   String currency,
				   String phoneCode,
				   String continent,
				   String description,
				   String size,
				   String independenceDate,
				   String population) {}



