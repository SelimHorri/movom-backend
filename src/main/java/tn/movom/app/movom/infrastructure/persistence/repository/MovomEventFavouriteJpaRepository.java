package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.MovomEventFavouriteEntity;
import tn.movom.app.movom.domain.repository.MovomEventFavouriteRepository;

import java.util.Optional;
import java.util.UUID;

public interface MovomEventFavouriteJpaRepository extends JpaRepository<MovomEventFavouriteEntity, Long> {
	
	Optional<MovomEventFavouriteEntity> findByUid(UUID uid);
	
}

@Repository
@RequiredArgsConstructor
class JpaMovomEventFavouriteRepository implements MovomEventFavouriteRepository {
	
	private final MovomEventFavouriteJpaRepository movomEventFavouriteJpaRepository;
	
	@Override
	public Optional<MovomEventFavouriteEntity> findByUid(UUID uid) {
		return this.movomEventFavouriteJpaRepository.findByUid(uid);
	}
	
}



