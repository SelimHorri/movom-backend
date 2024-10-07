package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.CountryEntity;

import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
	
	Optional<CountryEntity> findByUid(UUID uid);
	Optional<CountryEntity> findByDialCode(String dialCode);
	
}



