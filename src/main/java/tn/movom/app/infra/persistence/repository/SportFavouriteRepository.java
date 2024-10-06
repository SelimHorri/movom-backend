package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.SportFavouriteEntity;

import java.util.Optional;
import java.util.UUID;

public interface SportFavouriteRepository extends JpaRepository<SportFavouriteEntity, Long> {
	
	Optional<SportFavouriteEntity> findByUid(UUID uid);
	
}



