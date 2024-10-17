package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.CountryEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CountryRepository {
	
	List<CountryEntity> findAll();
	Optional<CountryEntity> findByUid(UUID uid);
	Optional<CountryEntity> findByDialCode(String dialCode);
	
}



