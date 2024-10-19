package tn.movom.app.movom.application;

import tn.movom.app.infra.model.Pagination;

import java.util.List;
import java.util.Optional;

public interface CountryDataRetriever {
	
	List<CountryInfo> findAll();
	
	List<CountryInfo> findAll(Pagination pagination);
	
	Optional<CountryInfo> findByName(String name);
	
	List<CountryInfo> findAllByContinent(String continent);
	
	List<CountryInfo> findAllByContinent(String continent, Pagination pagination);
	
}



