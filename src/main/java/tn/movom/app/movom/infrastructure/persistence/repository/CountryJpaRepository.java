package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.CountryEntity;
import tn.movom.app.movom.domain.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> {
	
	Optional<CountryEntity> findByUid(UUID uid);
	List<CountryEntity> findAllByDialCode(String dialCode);
	
}

@Repository
@RequiredArgsConstructor
class JpaCountryRepository implements CountryRepository {
	
	private final CountryJpaRepository countryJpaRepository;
	
	@Override
	public List<CountryEntity> findAll() {
		return this.countryJpaRepository.findAll();
	}
	
	public Optional<CountryEntity> findByUid(UUID uid) {
		return this.countryJpaRepository.findByUid(uid);
	}
	
	public List<CountryEntity> findAllByDialCode(String dialCode) {
		return this.countryJpaRepository.findAllByDialCode(dialCode);
	}
	
}



