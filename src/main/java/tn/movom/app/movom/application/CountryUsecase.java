package tn.movom.app.movom.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.movom.app.movom.Usecase;
import tn.movom.app.movom.domain.Country;
import tn.movom.app.movom.domain.mapper.CountryMapper;
import tn.movom.app.movom.domain.repository.CountryRepository;

import java.util.Comparator;
import java.util.List;

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
	
}



