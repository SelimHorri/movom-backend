package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.AmenityEntity;

import java.util.Optional;
import java.util.UUID;

public interface AmenityRepository extends JpaRepository<AmenityEntity, Long> {
	
	Optional<AmenityEntity> findByUid(UUID uid);
	
}



