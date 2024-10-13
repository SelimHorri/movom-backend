package tn.movom.app.movom.infrastructure.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import tn.movom.app.movom.application.CountryDataRetriever;
import tn.movom.app.movom.application.CountryInfo;
import tn.movom.app.movom.infrastructure.client.CountryHttpClient.UniCountryData;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
class RemoteCountryDataRetriever implements CountryDataRetriever {
	
	private static final String PHONE_CODE_PREFIX = "+";
	private final CountryHttpClient countryClient;
	
	@Override
	public List<CountryInfo> findAll() {
		try {
			return this.countryClient.findAllCountries().data().stream()
					.map(RemoteCountryDataRetriever::convertFrom)
					.toList();
		}
		catch (HttpClientErrorException e) {
			log.error("HttpClientErrorException occurred: ", e);
			return List.of();
		}
		catch (RuntimeException e) {
			log.error("RuntimeException occurred: ", e);
			return List.of();
		}
	}
	
	@Override
	public Optional<CountryInfo> findByNameOptional(String name) {
		try {
			return Optional.ofNullable(this.countryClient.findCountryByName(name))
					.map(UniCountryData::data)
					.map(RemoteCountryDataRetriever::convertFrom);
		}
		catch (HttpClientErrorException e) {
			log.error("HttpClientErrorException occurred: ", e);
			return Optional.empty();
		}
		catch (RuntimeException e) {
			log.error("RuntimeException occurred: ", e);
			return Optional.empty();
		}
	}
	
	private static CountryInfo convertFrom(CountryNetworkInfo countryNetworkInfo) {
		return new CountryInfo(
				(countryNetworkInfo.phoneCode().startsWith(PHONE_CODE_PREFIX))
						? countryNetworkInfo.phoneCode()
						: PHONE_CODE_PREFIX + countryNetworkInfo.phoneCode(),
				countryNetworkInfo.name(),
				countryNetworkInfo.continent());
	}
	
}



