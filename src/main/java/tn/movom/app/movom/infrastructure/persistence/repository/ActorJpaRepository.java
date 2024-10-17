package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.ActorEntity;
import tn.movom.app.movom.domain.repository.ActorRepository;

import java.util.Optional;
import java.util.UUID;

public interface ActorJpaRepository extends JpaRepository<ActorEntity, Long> {
	
	Optional<ActorEntity> findByUid(UUID uid);
	Optional<ActorEntity> findBySsn(String ssn);
	Optional<ActorEntity> findByEmail(String email);
	
}

@Repository
@RequiredArgsConstructor
class JpaActorRepository implements ActorRepository {
	
	private final ActorJpaRepository actorJpaRepository;
	
	@Override
	public Optional<ActorEntity> findByUid(UUID uid) {
		return this.actorJpaRepository.findByUid(uid);
	}
	
	@Override
	public Optional<ActorEntity> findBySsn(String ssn) {
		return this.actorJpaRepository.findBySsn(ssn);
	}
	
	@Override
	public Optional<ActorEntity> findByEmail(String email) {
		return this.actorJpaRepository.findByEmail(email);
	}
	
}



