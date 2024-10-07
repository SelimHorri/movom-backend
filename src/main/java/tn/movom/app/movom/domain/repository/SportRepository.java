package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.SportEntity;

import java.util.Optional;
import java.util.UUID;

public interface SportRepository extends JpaRepository<SportEntity, Long> {
	
	Optional<SportEntity> findByUid(UUID uid);
	
}



