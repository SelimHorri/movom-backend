package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.AmenityReviewerEntity;

import java.util.Optional;
import java.util.UUID;

public interface AmenityReviewerRepository extends JpaRepository<AmenityReviewerEntity, Long> {
	
	Optional<AmenityReviewerEntity> findByUid(UUID uid);
	
}



