package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.ActorEntity;

import java.util.Optional;
import java.util.UUID;

public interface ActorRepository {
	
	Optional<ActorEntity> findByUid(UUID uid);
	Optional<ActorEntity> findBySsn(String ssn);
	Optional<ActorEntity> findByEmail(String email);
	
}



