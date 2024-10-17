package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.AmenityReviewerEntity;

import java.util.Optional;
import java.util.UUID;

public interface AmenityReviewerRepository {
	
	Optional<AmenityReviewerEntity> findByUid(UUID uid);
	
}



