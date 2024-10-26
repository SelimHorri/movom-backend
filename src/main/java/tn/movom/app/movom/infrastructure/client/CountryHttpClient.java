package tn.movom.app.movom.infrastructure.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;
import java.util.Objects;

@HttpExchange("/countries")
public interface CountryHttpClient {
	
	@GetExchange
	MultiCountryData findAllCountries();
	
	@GetExchange
	MultiCountryData findAllCountries(@RequestParam("per_page") int offset);
	
	@GetExchange("/{country}")
	UniCountryData findCountryByName(@PathVariable("country") String name);
	
	@GetExchange
	MultiCountryData findAllByContinent(@RequestParam String continent);
	
	@GetExchange
	MultiCountryData findAllByContinent(@RequestParam String continent, @RequestParam("per_page") int offset);
	
	record MultiCountryData(List<CountryNetworkInfo> data) {
		
		public MultiCountryData {
			data = List.copyOf(Objects.requireNonNullElseGet(data, List::of));
		}
		
	}
	record UniCountryData(CountryNetworkInfo data) {
		
		public UniCountryData {
			data = Objects.requireNonNullElseGet(data, CountryNetworkInfo.builder()::build);
		}
		
	}
	
}



