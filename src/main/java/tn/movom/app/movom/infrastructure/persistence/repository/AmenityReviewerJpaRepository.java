package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.AmenityReviewerEntity;
import tn.movom.app.movom.domain.repository.AmenityReviewerRepository;

import java.util.Optional;
import java.util.UUID;

public interface AmenityReviewerJpaRepository extends JpaRepository<AmenityReviewerEntity, Long> {
	
	Optional<AmenityReviewerEntity> findByUid(UUID uid);
	
}

@Repository
@RequiredArgsConstructor
class JpaAmenityReviewerRepository implements AmenityReviewerRepository {
	
	private final AmenityReviewerJpaRepository amenityReviewerJpaRepository;
	
	@Override
	public Optional<AmenityReviewerEntity> findByUid(UUID uid) {
		return this.amenityReviewerJpaRepository.findByUid(uid);
	}
	
}



