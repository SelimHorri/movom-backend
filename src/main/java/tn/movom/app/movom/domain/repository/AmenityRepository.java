package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.AmenityEntity;

import java.util.Optional;
import java.util.UUID;

public interface AmenityRepository {
	
	Optional<AmenityEntity> findByUid(UUID uid);
	
}



