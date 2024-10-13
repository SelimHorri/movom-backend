package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.Accomodation;
import tn.movom.app.movom.domain.Actor;
import tn.movom.app.movom.domain.entity.AccomodationEntity;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccomodationMapper {
	
	public static Accomodation from(AccomodationEntity accomodation) {
		return Accomodation.builder()
				.uid(accomodation.getUid())
				.title(accomodation.getTitle())
				.fullAddress(accomodation.getFullAddress())
				.zipcode(accomodation.getZipcode())
				.countryDialCode(accomodation.getCountryDialCode())
				.ownerName(accomodation.getOwnerName())
				.numberOfRooms(accomodation.getNumberOfRooms())
				.description(accomodation.getDescription())
				.actor(Actor.builder()
						.uid(accomodation.getActor().getUid())
						.ssn(accomodation.getActor().getSsn())
						.isVerified(accomodation.getActor().getIsVerified())
						.firstname(accomodation.getActor().getFirstname())
						.lastname(accomodation.getActor().getLastname())
						.email(accomodation.getActor().getEmail())
						.selfDescription(accomodation.getActor().getSelfDescription())
						.phone(accomodation.getActor().getPhone())
						.countryDialCode(accomodation.getActor().getCountryDialCode())
						.speakingLangs(
								accomodation.getActor().getSpeakingLangs().lines()
										.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
										.collect(Collectors.toUnmodifiableSet()))
						.jobTitle(accomodation.getActor().getJobTitle())
						.joinedAt(accomodation.getActor().getJoinedAt())
						//.credential(null)
						.build())
				.build();
	}
	
}



