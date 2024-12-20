package tn.movom.app.movom.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.movom.app.infra.model.PageDetail;
import tn.movom.app.infra.model.Pagination;
import tn.movom.app.movom.Usecase;
import tn.movom.app.movom.domain.MovomEvent;
import tn.movom.app.movom.domain.mapper.MovomEventMapper;
import tn.movom.app.movom.domain.repository.MovomEventRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Usecase
@Slf4j
@RequiredArgsConstructor
public class MovomEventUsecase {
	
	private final MovomEventRepository movomEventRepository;
	
	public PageDetail<MovomEvent> findAllMovomEventsBetween(LocalDate startDay, LocalDate endDay, Pagination pagination) {
		if (startDay == null && endDay == null) {
			log.info("find all movom events without date range.");
			return this.movomEventRepository
					.findAll(pagination)
					.map(MovomEventMapper::from);
		}
		
		var startsAt = (startDay != null) ? startDay.atStartOfDay() : LocalDateTime.now();
		var endsAt = (endDay != null) ? endDay.plusDays(1).atStartOfDay() : LocalDateTime.now();
		
		if (startsAt.isAfter(endsAt))
			throw new IllegalArgumentException("Invalid date range: start date %s is after end date %s".formatted(startsAt, endsAt));
		
		log.info("find all movom events between startsAt: {} & endsAt: {}.", startsAt, endsAt);
		
		return this.movomEventRepository
				.findAllBetweenStartsAtAndEndsAt(startsAt, endsAt, pagination)
				.map(MovomEventMapper::from);
	}
	
}



