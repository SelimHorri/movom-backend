package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.MovomEventFavouriteEntity;

import java.util.Optional;
import java.util.UUID;

public interface MovomEventFavouriteRepository extends JpaRepository<MovomEventFavouriteEntity, Long> {
	
	Optional<MovomEventFavouriteEntity> findByUid(UUID uid);
	
}



