package tn.movom.app.movom.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.movom.app.movom.domain.Sport;
import tn.movom.app.movom.domain.mapper.SportMapper;
import tn.movom.app.movom.domain.repository.SportRepository;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class SportUsecase {
	
	private final SportRepository sportRepository;
	
	public List<Sport> findAllSports() {
		return this.sportRepository.findAll().stream()
				.map(SportMapper::from)
				.sorted(Comparator.comparing(Sport::name))
				.toList();
	}
	
}



