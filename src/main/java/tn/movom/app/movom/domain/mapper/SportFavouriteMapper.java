package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.Actor;
import tn.movom.app.movom.domain.Sport;
import tn.movom.app.movom.domain.SportFavourite;
import tn.movom.app.movom.domain.entity.SportFavouriteEntity;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SportFavouriteMapper {
	
	public static SportFavourite from(SportFavouriteEntity sportFavourite) {
		return SportFavourite.builder()
				.uid(sportFavourite.getUid())
				.favouredAt(sportFavourite.getFavouredAt())
				.actor(Actor.builder()
						.uid(sportFavourite.getActor().getUid())
						.ssn(sportFavourite.getActor().getSsn())
						.isVerified(sportFavourite.getActor().getIsVerified())
						.firstname(sportFavourite.getActor().getFirstname())
						.lastname(sportFavourite.getActor().getLastname())
						.email(sportFavourite.getActor().getEmail())
						.selfDescription(sportFavourite.getActor().getSelfDescription())
						.phone(sportFavourite.getActor().getPhone())
						.countryDialCode(sportFavourite.getActor().getCountryDialCode())
						.speakingLangs(
								sportFavourite.getActor().getSpeakingLangs().lines()
										.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
										.collect(Collectors.toUnmodifiableSet()))
						.jobTitle(sportFavourite.getActor().getJobTitle())
						.joinedAt(sportFavourite.getActor().getJoinedAt())
						.build())
				.sport(new Sport(
						sportFavourite.getSport().getUid(),
						sportFavourite.getSport().getName(),
						sportFavourite.getSport().getCompetitionName()))
				.build();
	}
	
}



