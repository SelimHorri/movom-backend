package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.SportFavouriteEntity;

import java.util.Optional;
import java.util.UUID;

public interface SportFavouriteRepository {
	
	Optional<SportFavouriteEntity> findByUid(UUID uid);
	
}



