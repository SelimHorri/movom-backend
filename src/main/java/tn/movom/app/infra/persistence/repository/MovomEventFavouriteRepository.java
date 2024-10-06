package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.MovomEventFavouriteEntity;

import java.util.Optional;
import java.util.UUID;

public interface MovomEventFavouriteRepository extends JpaRepository<MovomEventFavouriteEntity, Long> {
	
	Optional<MovomEventFavouriteEntity> findByUid(UUID uid);
	
}



