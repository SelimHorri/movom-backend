package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.movom.domain.Accomodation;
import tn.movom.app.movom.domain.Amenity;
import tn.movom.app.movom.domain.entity.AmenityEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AmenityMapper {
	
	public static Amenity from(AmenityEntity amenity) {
		return Amenity.builder()
				.uid(amenity.getUid())
				.name(amenity.getName())
				.description(amenity.getDescription())
				.accomodation(Accomodation.builder()
						.uid(amenity.getAccomodation().getUid())
						.title(amenity.getAccomodation().getTitle())
						.fullAddress(amenity.getAccomodation().getFullAddress())
						.zipcode(amenity.getAccomodation().getZipcode())
						.countryDialCode(amenity.getAccomodation().getCountryDialCode())
						.ownerName(amenity.getAccomodation().getOwnerName())
						.numberOfRooms(amenity.getAccomodation().getNumberOfRooms())
						.description(amenity.getAccomodation().getDescription())
						.build())
				.build();
	}
	
}



