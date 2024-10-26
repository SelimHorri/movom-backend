package tn.movom.app.movom.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.movom.app.movom.Usecase;
import tn.movom.app.movom.domain.ContinentName;
import tn.movom.app.movom.domain.Country;
import tn.movom.app.movom.domain.mapper.CountryMapper;
import tn.movom.app.movom.domain.repository.CountryRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Usecase
@Slf4j
@RequiredArgsConstructor
public class CountryUsecase {
	
	private final CountryRepository countryRepository;
	
	public List<Country> findAllCountries() {
		return this.countryRepository.findAll().stream()
				.map(CountryMapper::from)
				.sorted(Comparator
						.comparing(Country::name)
						.thenComparing(Country::dialCode))
				.toList();
	}
	
	public List<CountriesByContinent> findAllCountriesByContinents() {
		Map<ContinentName, List<Country>> byContinents = this.countryRepository.findAll().stream()
				.map(CountryMapper::from)
				.collect(Collectors.groupingBy(Country::continent));
		
		return byContinents.entrySet().stream()
				.map(CountriesByContinent::new)
				.sorted(Comparator.comparing(CountriesByContinent::continent))
				.toList();
	}
	
}



