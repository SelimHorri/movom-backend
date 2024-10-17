package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.SportEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SportRepository {
	
	List<SportEntity> findAll();
	Optional<SportEntity> findByUid(UUID uid);
	
}



