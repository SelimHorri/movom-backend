package tn.movom.app.movom.application;

import java.util.List;
import java.util.Optional;

public interface CountryDataRetriever {
	
	List<CountryInfo> findAll();
	Optional<CountryInfo> findByNameOptional(String name);
	
}



