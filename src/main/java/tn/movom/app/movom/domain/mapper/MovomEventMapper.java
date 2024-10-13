package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.Actor;
import tn.movom.app.movom.domain.Country;
import tn.movom.app.movom.domain.MovomEvent;
import tn.movom.app.movom.domain.Sport;
import tn.movom.app.movom.domain.entity.MovomEventEntity;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MovomEventMapper {
	
	public static MovomEvent from(MovomEventEntity movomEvent) {
		return MovomEvent.builder()
				.uid(movomEvent.getUid())
				.title(movomEvent.getTitle())
				.status(movomEvent.getStatus())
				.startsAt(movomEvent.getStartsAt())
				.endsAt(movomEvent.getEndsAt())
				.description(movomEvent.getDescription())
				.fullLocation(movomEvent.getFullLocation())
				.facilityName(movomEvent.getFacilityName())
				.actor(Actor.builder()
						.uid(movomEvent.getActor().getUid())
						.ssn(movomEvent.getActor().getSsn())
						.isVerified(movomEvent.getActor().getIsVerified())
						.firstname(movomEvent.getActor().getFirstname())
						.lastname(movomEvent.getActor().getLastname())
						.email(movomEvent.getActor().getEmail())
						.selfDescription(movomEvent.getActor().getSelfDescription())
						.phone(movomEvent.getActor().getPhone())
						.countryDialCode(movomEvent.getActor().getCountryDialCode())
						.speakingLangs(
								movomEvent.getActor().getSpeakingLangs().lines()
										.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
										.collect(Collectors.toUnmodifiableSet()))
						.jobTitle(movomEvent.getActor().getJobTitle())
						.joinedAt(movomEvent.getActor().getJoinedAt())
						.build())
				.sport(new Sport(
						movomEvent.getSport().getUid(),
						movomEvent.getSport().getName(),
						movomEvent.getSport().getCompetitionName()))
				.country(new Country(
						movomEvent.getCountry().getUid(),
						movomEvent.getCountry().getDialCode(),
						movomEvent.getCountry().getName()))
				.build();
	}
	
}



