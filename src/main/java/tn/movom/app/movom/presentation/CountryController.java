package tn.movom.app.movom.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tn.movom.app.infra.model.payload.ApiPayload;
import tn.movom.app.movom.application.CountriesByContinent;
import tn.movom.app.movom.application.CountryUsecase;
import tn.movom.app.movom.domain.Country;

import java.util.List;

@RestController
@RequestMapping("${movom.api-version}/countries")
@RequiredArgsConstructor
class CountryController {
	
	private final CountryUsecase countryUsecase;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	ApiPayload<List<Country>> findAllCountries() {
		var allCountries = this.countryUsecase.findAllCountries();
		return ApiPayload.ofSuccess(allCountries.size(), allCountries);
	}
	
	@GetMapping("/by-continents")
	ApiPayload<List<CountriesByContinent>> findAllCountriesByContinents() {
		var countriesByContinents = this.countryUsecase.findAllCountriesByContinents();
		return ApiPayload.ofSuccess(countriesByContinents.size(), countriesByContinents);
	}
	
}



