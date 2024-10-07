package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.AccomodationEntity;

import java.util.Optional;
import java.util.UUID;

public interface AccomodationRepository extends JpaRepository<AccomodationEntity, Long> {
	
	Optional<AccomodationEntity> findByUid(UUID uid);
	
}



