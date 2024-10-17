package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.SportEntity;
import tn.movom.app.movom.domain.repository.SportRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SportJpaRepository extends JpaRepository<SportEntity, Long> {
	
	Optional<SportEntity> findByUid(UUID uid);
	
}

@Repository
@RequiredArgsConstructor
class JpaSportRepository implements SportRepository {
	
	private final SportJpaRepository sportJpaRepository;
	
	@Override
	public List<SportEntity> findAll() {
		return this.sportJpaRepository.findAll();
	}
	
	@Override
	public Optional<SportEntity> findByUid(UUID uid) {
		return this.sportJpaRepository.findByUid(uid);
	}
	
}



