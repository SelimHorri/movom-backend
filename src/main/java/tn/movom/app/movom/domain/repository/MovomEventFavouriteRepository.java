package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.MovomEventFavouriteEntity;

import java.util.Optional;
import java.util.UUID;

public interface MovomEventFavouriteRepository {
	
	Optional<MovomEventFavouriteEntity> findByUid(UUID uid);
	
}



