package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.MovomEventEntity;

import java.util.Optional;
import java.util.UUID;

public interface MovomEventRepository extends JpaRepository<MovomEventEntity, Long> {
	
	Optional<MovomEventEntity> findByUid(UUID uid);
	
}



