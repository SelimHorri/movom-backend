package tn.movom.app.movom.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.movom.app.movom.domain.entity.MovomEventEntity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface MovomEventRepository extends JpaRepository<MovomEventEntity, Long> {
	
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



