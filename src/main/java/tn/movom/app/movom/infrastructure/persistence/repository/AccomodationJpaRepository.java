package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.AccomodationEntity;
import tn.movom.app.movom.domain.repository.AccomodationRepository;

import java.util.Optional;
import java.util.UUID;

interface AccomodationJpaRepository extends JpaRepository<AccomodationEntity, Long> {
	
	Optional<AccomodationEntity> findByUid(UUID uid);
	
}

@Repository
@RequiredArgsConstructor
class JpaAccomodationRepository implements AccomodationRepository {
	
	private final AccomodationJpaRepository accomodationJpaRepository;
	
	@Override
	public Optional<AccomodationEntity> findByUid(UUID uid) {
		return this.accomodationJpaRepository.findByUid(uid);
	}
	
}



