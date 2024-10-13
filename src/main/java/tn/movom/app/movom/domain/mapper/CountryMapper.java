package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.movom.application.CountryInfo;
import tn.movom.app.movom.domain.Country;
import tn.movom.app.movom.domain.entity.CountryEntity;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CountryMapper {
	
	public static Country from(CountryEntity country) {
		return new Country(country.getUid(), country.getDialCode(), country.getName());
	}
	
	public static Country from(CountryInfo countryInfo) {
		return new Country(UUID.randomUUID(), countryInfo.dialCode(), countryInfo.name());
	}
	
}



