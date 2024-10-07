package tn.movom.app.movom.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.movom.domain.entity.SportFavouriteEntity;

import java.util.Optional;
import java.util.UUID;

public interface SportFavouriteRepository extends JpaRepository<SportFavouriteEntity, Long> {
	
	Optional<SportFavouriteEntity> findByUid(UUID uid);
	
}


