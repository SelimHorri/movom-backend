package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.AccomodationEntity;

import java.util.Optional;
import java.util.UUID;

public interface AccomodationRepository {
	
	Optional<AccomodationEntity> findByUid(UUID uid);
	
}



