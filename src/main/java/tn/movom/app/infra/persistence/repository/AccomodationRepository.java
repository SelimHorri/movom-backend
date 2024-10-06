package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.AccomodationEntity;

import java.util.Optional;
import java.util.UUID;

public interface AccomodationRepository extends JpaRepository<AccomodationEntity, Long> {
	
	Optional<AccomodationEntity> findByUid(UUID uid);
	
}



