package tn.movom.app.movom.application;

import tn.movom.app.movom.domain.ContinentName;
import tn.movom.app.movom.domain.Country;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public record CountriesByContinent(ContinentName continent, List<Country> countries) {
	
	public CountriesByContinent {
		countries = List.copyOf(Objects.requireNonNullElseGet(countries, List::of));
	}
	
	public CountriesByContinent(Map.Entry<ContinentName, List<Country>> countriesByContinentEntry) {
		this(countriesByContinentEntry.getKey(), countriesByContinentEntry.getValue());
	}
	
}



