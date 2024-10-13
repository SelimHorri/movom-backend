package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.Actor;
import tn.movom.app.movom.domain.Amenity;
import tn.movom.app.movom.domain.AmenityReviewer;
import tn.movom.app.movom.domain.entity.AmenityReviewerEntity;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AmenityReviewerMapper {
	
	public static AmenityReviewer from(AmenityReviewerEntity amenityReviewer) {
		return AmenityReviewer.builder()
				.uid(amenityReviewer.getUid())
				.rate(amenityReviewer.getRate())
				.reviewedAt(amenityReviewer.getReviewedAt())
				.reviewerComment(amenityReviewer.getReviewerComment())
				.amenity(Amenity.builder()
						.uid(amenityReviewer.getAmenity().getUid())
						.name(amenityReviewer.getAmenity().getName())
						.description(amenityReviewer.getAmenity().getDescription())
						.build())
				.actor(Actor.builder()
						.uid(amenityReviewer.getReviewer().getUid())
						.ssn(amenityReviewer.getReviewer().getSsn())
						.isVerified(amenityReviewer.getReviewer().getIsVerified())
						.firstname(amenityReviewer.getReviewer().getFirstname())
						.lastname(amenityReviewer.getReviewer().getLastname())
						.email(amenityReviewer.getReviewer().getEmail())
						.selfDescription(amenityReviewer.getReviewer().getSelfDescription())
						.phone(amenityReviewer.getReviewer().getPhone())
						.countryDialCode(amenityReviewer.getReviewer().getCountryDialCode())
						.speakingLangs(
								amenityReviewer.getReviewer().getSpeakingLangs().lines()
										.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
										.collect(Collectors.toUnmodifiableSet()))
						.jobTitle(amenityReviewer.getReviewer().getJobTitle())
						.joinedAt(amenityReviewer.getReviewer().getJoinedAt())
						.build())
				.build();
	}
	
}



