package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.AmenityReviewerEntity;

import java.util.Optional;
import java.util.UUID;

public interface AmenityReviewerRepository extends JpaRepository<AmenityReviewerEntity, Long> {
	
	Optional<AmenityReviewerEntity> findByUid(UUID uid);
	
}



