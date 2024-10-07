package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.AmenityEntity;

import java.util.Optional;
import java.util.UUID;

public interface AmenityRepository extends JpaRepository<AmenityEntity, Long> {
	
	Optional<AmenityEntity> findByUid(UUID uid);
	
}



