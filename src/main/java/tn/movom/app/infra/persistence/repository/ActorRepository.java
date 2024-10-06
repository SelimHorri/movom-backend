package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.ActorEntity;

import java.util.Optional;
import java.util.UUID;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
	
	Optional<ActorEntity> findByUid(UUID uid);
	Optional<ActorEntity> findBySsn(String ssn);
	Optional<ActorEntity> findByEmail(String email);
	
}



