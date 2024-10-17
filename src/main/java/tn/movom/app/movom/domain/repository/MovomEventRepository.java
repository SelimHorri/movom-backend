package tn.movom.app.movom.domain.repository;

import tn.movom.app.infra.model.PageDetail;
import tn.movom.app.infra.model.Pagination;
import tn.movom.app.movom.domain.entity.MovomEventEntity;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

public interface MovomEventRepository {
	
	PageDetail<MovomEventEntity> findAll(Pagination pagination);
	Optional<MovomEventEntity> findByUid(UUID uid);
	PageDetail<MovomEventEntity> findAllBetweenStartsAtAndEndsAt(LocalDateTime startsAt, LocalDateTime endsAt, Pagination pagination);
	
}



