package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.SportFavouriteEntity;
import tn.movom.app.movom.domain.repository.SportFavouriteRepository;

import java.util.Optional;
import java.util.UUID;

public interface SportFavouriteJpaRepository extends JpaRepository<SportFavouriteEntity, Long> {
	
	Optional<SportFavouriteEntity> findByUid(UUID uid);
	
}

@Repository
@RequiredArgsConstructor
class JpaSportFavouriteRepository implements SportFavouriteRepository {
	
	private final SportFavouriteJpaRepository sportFavouriteJpaRepository;
	
	@Override
	public Optional<SportFavouriteEntity> findByUid(UUID uid) {
		return this.sportFavouriteJpaRepository.findByUid(uid);
	}
	
}



