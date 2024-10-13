package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.movom.domain.Sport;
import tn.movom.app.movom.domain.entity.SportEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SportMapper {
	
	public static Sport from(SportEntity sport) {
		return new Sport(sport.getUid(), sport.getName(), sport.getCompetitionName());
	}
	
}



