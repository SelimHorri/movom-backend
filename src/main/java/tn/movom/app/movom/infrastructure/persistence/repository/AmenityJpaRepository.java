package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.AmenityEntity;
import tn.movom.app.movom.domain.repository.AmenityRepository;

import java.util.Optional;
import java.util.UUID;

public interface AmenityJpaRepository extends JpaRepository<AmenityEntity, Long> {
	
	Optional<AmenityEntity> findByUid(UUID uid);
	
}

@Repository
@RequiredArgsConstructor
class JpaAmenityRepository implements AmenityRepository {
	
	private final AmenityJpaRepository amenityJpaRepository;
	
	@Override
	public Optional<AmenityEntity> findByUid(UUID uid) {
		return this.amenityJpaRepository.findByUid(uid);
	}
	
}



