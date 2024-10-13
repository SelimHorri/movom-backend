package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.Actor;
import tn.movom.app.movom.domain.MovomEvent;
import tn.movom.app.movom.domain.MovomEventFavourite;
import tn.movom.app.movom.domain.entity.MovomEventFavouriteEntity;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MovomEventFavouriteMapper {
	
	public static MovomEventFavourite from(MovomEventFavouriteEntity movomEventFavourite) {
		return MovomEventFavourite.builder()
				.uid(movomEventFavourite.getUid())
				.favouredAt(movomEventFavourite.getFavouredAt())
				.actor(Actor.builder()
						.uid(movomEventFavourite.getActor().getUid())
						.ssn(movomEventFavourite.getActor().getSsn())
						.isVerified(movomEventFavourite.getActor().getIsVerified())
						.firstname(movomEventFavourite.getActor().getFirstname())
						.lastname(movomEventFavourite.getActor().getLastname())
						.email(movomEventFavourite.getActor().getEmail())
						.selfDescription(movomEventFavourite.getActor().getSelfDescription())
						.phone(movomEventFavourite.getActor().getPhone())
						.countryDialCode(movomEventFavourite.getActor().getCountryDialCode())
						.speakingLangs(
								movomEventFavourite.getActor().getSpeakingLangs().lines()
										.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
										.collect(Collectors.toUnmodifiableSet()))
						.jobTitle(movomEventFavourite.getActor().getJobTitle())
						.joinedAt(movomEventFavourite.getActor().getJoinedAt())
						.build())
				.movomEvent(MovomEvent.builder()
						.uid(movomEventFavourite.getMovomEvent().getUid())
						.title(movomEventFavourite.getMovomEvent().getTitle())
						.status(movomEventFavourite.getMovomEvent().getStatus())
						.startsAt(movomEventFavourite.getMovomEvent().getStartsAt())
						.endsAt(movomEventFavourite.getMovomEvent().getEndsAt())
						.description(movomEventFavourite.getMovomEvent().getDescription())
						.fullLocation(movomEventFavourite.getMovomEvent().getFullLocation())
						.facilityName(movomEventFavourite.getMovomEvent().getFacilityName())
						.build())
				.build();
	}
	
}



