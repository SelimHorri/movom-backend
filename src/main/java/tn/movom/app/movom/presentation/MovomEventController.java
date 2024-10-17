package tn.movom.app.movom.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.infra.model.PageDetail;
import tn.movom.app.infra.model.Pagination;
import tn.movom.app.infra.model.payload.ApiPayload;
import tn.movom.app.movom.application.MovomEventUsecase;
import tn.movom.app.movom.domain.MovomEvent;

import java.time.LocalDate;

@RestController
@RequestMapping("${movom.api-version}/events")
@RequiredArgsConstructor
class MovomEventController {
	
	private final MovomEventUsecase movomEventUsecase;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	ApiPayload<PageDetail<MovomEvent>> findAllMovomEventsBetween(@RequestParam(required = false, name = "start_day")
																 @DateTimeFormat(pattern = AppConstants.LOCAL_DATE_FORMAT) LocalDate startDay,
																 @RequestParam(required = false, name = "end_day")
																 @DateTimeFormat(pattern = AppConstants.LOCAL_DATE_FORMAT) LocalDate endDay,
																 @RequestParam(required = false) String offset,
																 @RequestParam(required = false) String size,
																 @RequestParam(required = false, name = "sort_direction") String sortDirection,
																 @RequestParam(required = false, name = "sort_by") String sortBy) {
		var pageableMovomEvents = this.movomEventUsecase
				.findAllMovomEventsBetween(startDay, endDay, Pagination.of(offset, size, sortDirection, sortBy));
		return ApiPayload.ofSuccess(pageableMovomEvents.content().size(), pageableMovomEvents);
	}
	
}



