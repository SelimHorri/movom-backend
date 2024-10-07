package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.MovomEventEntity;

import java.util.Optional;
import java.util.UUID;

public interface MovomEventRepository extends JpaRepository<MovomEventEntity, Long> {
	
	Optional<MovomEventEntity> findByUid(UUID uid);
	
}



