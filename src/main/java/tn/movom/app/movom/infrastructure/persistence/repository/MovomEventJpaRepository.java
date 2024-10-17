package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.movom.app.infra.model.PageDetail;
import tn.movom.app.infra.model.Pagination;
import tn.movom.app.movom.domain.entity.MovomEventEntity;
import tn.movom.app.movom.domain.repository.MovomEventRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface MovomEventJpaRepository extends JpaRepository<MovomEventEntity, Long> {
	
	Optional<MovomEventEntity> findByUid(UUID uid);
	
	@Query("""
		SELECT e
		FROM MovomEventEntity e
		WHERE
				e.startsAt >= :startsAt
			AND e.endsAt <= :endsAt
		""")
	Page<MovomEventEntity> findAllBetweenStartsAtAndEndsAt(LocalDateTime startsAt, LocalDateTime endsAt, Pageable pageable);
	
}

@Repository
@RequiredArgsConstructor
class JpaMovomEventRepository implements MovomEventRepository {
	
	private final MovomEventJpaRepository movomEventJpaRepository;
	
	@Override
	public PageDetail<MovomEventEntity> findAll(Pagination pagination) {
		return PageDetail.from(
				this.movomEventJpaRepository.findAll(pagination.toPageable()));
	}
	
	@Override
	public Optional<MovomEventEntity> findByUid(UUID uid) {
		return this.movomEventJpaRepository.findByUid(uid);
	}
	
	@Override
	public PageDetail<MovomEventEntity> findAllBetweenStartsAtAndEndsAt(LocalDateTime startsAt, LocalDateTime endsAt, Pagination pagination) {
		return PageDetail.from(this.movomEventJpaRepository
				.findAllBetweenStartsAtAndEndsAt(startsAt, endsAt, pagination.toPageable()));
	}
	
}



