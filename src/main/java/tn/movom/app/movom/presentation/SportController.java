package tn.movom.app.movom.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tn.movom.app.infra.model.payload.ApiPayload;
import tn.movom.app.movom.application.SportUsecase;
import tn.movom.app.movom.domain.Sport;

import java.util.List;

@RestController
@RequestMapping("${movom.api-version}/sports")
@RequiredArgsConstructor
class SportController {
	
	private final SportUsecase sportUsecase;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	ApiPayload<List<Sport>> findAllSports() {
		var allSports = this.sportUsecase.findAllSports();
		return ApiPayload.ofSuccess(allSports.size(), allSports);
	}
	
}



