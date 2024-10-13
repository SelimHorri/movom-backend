package tn.movom.app.movom.infrastructure.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/countries")
public interface CountryHttpClient {
	
	@GetExchange
	MultiCountryData findAllCountries();
	
	@GetExchange("/{country}")
	UniCountryData findCountryByName(@PathVariable("country") String name);
	
	record MultiCountryData(List<CountryNetworkInfo> data) {}
	record UniCountryData(CountryNetworkInfo data) {}
	
}



