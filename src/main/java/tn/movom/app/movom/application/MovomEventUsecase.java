package tn.movom.app.movom.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.movom.app.infra.model.PageDetail;
import tn.movom.app.infra.model.Pagination;
import tn.movom.app.movom.domain.MovomEvent;
import tn.movom.app.movom.domain.entity.MovomEventEntity;
import tn.movom.app.movom.domain.repository.MovomEventRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class MovomEventUsecase {
	
	private final MovomEventRepository movomEventRepository;
	
	public PageDetail<MovomEvent> findAllMovomEventsBetween(LocalDate startDay, LocalDate endDay, Pagination pagination) {
		if (startDay == null && endDay == null) {
			log.info("find all movom events without date range.");
			var pageableMovomEvents = this.movomEventRepository
					.findAll(pagination.toPageable())
					.map(MovomEventEntity::toMovomEvent);
			return PageDetail.from(pageableMovomEvents);
		}
		
		var startsAt = (startDay != null) ? startDay.atStartOfDay() : LocalDateTime.now();
		var endsAt = (endDay != null) ? endDay.plusDays(1).atStartOfDay() : LocalDateTime.now();
		
		if (startsAt.isAfter(endsAt))
			throw new IllegalArgumentException("Invalid date range: start date %s is after end date %s".formatted(startsAt, endsAt));
		
		log.info("find all movom events between startsAt: {} & endsAt: {}.", startsAt, endsAt);
		
		var pageableMovomEvents = this.movomEventRepository
				.findAllBetweenStartsAtAndEndsAt(startsAt, endsAt, pagination.toPageable())
				.map(MovomEventEntity::toMovomEvent);
		
		return PageDetail.from(pageableMovomEvents);
	}
	
}



