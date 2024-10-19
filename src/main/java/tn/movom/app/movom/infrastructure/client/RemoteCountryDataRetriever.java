package tn.movom.app.movom.infrastructure.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import tn.movom.app.infra.model.Pagination;
import tn.movom.app.movom.application.CountryDataRetriever;
import tn.movom.app.movom.application.CountryInfo;
import tn.movom.app.movom.infrastructure.client.CountryHttpClient.UniCountryData;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
@Slf4j
@RequiredArgsConstructor
class RemoteCountryDataRetriever implements CountryDataRetriever {
	
	private static final String PHONE_CODE_PREFIX = "+";
	private final CountryHttpClient countryClient;
	
	@Override
	public List<CountryInfo> findAll() {
		return call(() -> this.countryClient
						.findAllCountries().data().stream()
						.map(RemoteCountryDataRetriever::convertFrom)
						.toList(),
				List::of);
	}
	
	@Override
	public List<CountryInfo> findAll(Pagination pagination) {
		return call(() -> this.countryClient
						.findAllCountries(pagination.getOffset()).data().stream()
						.map(RemoteCountryDataRetriever::convertFrom)
						.toList(),
				List::of);
	}
	
	@Override
	public Optional<CountryInfo> findByName(String name) {
		return call(() -> Optional
						.ofNullable(this.countryClient.findCountryByName(name))
						.map(UniCountryData::data)
						.map(RemoteCountryDataRetriever::convertFrom),
				Optional::empty);
	}
	
	@Override
	public List<CountryInfo> findAllByContinent(String continent) {
		return call(() -> this.countryClient.findAllByContinent(continent)
						.data().stream()
						.map(RemoteCountryDataRetriever::convertFrom)
						.toList(),
				List::of);
	}
	
	@Override
	public List<CountryInfo> findAllByContinent(String continent, Pagination pagination) {
		return call(() -> this.countryClient.findAllByContinent(continent, pagination.getOffset())
						.data().stream()
						.map(RemoteCountryDataRetriever::convertFrom)
						.toList(),
				List::of);
	}
	
	private static CountryInfo convertFrom(CountryNetworkInfo countryNetworkInfo) {
		return new CountryInfo(
				(countryNetworkInfo.phoneCode().startsWith(PHONE_CODE_PREFIX))
						? countryNetworkInfo.phoneCode()
						: PHONE_CODE_PREFIX + countryNetworkInfo.phoneCode(),
				countryNetworkInfo.name(),
				countryNetworkInfo.continent());
	}
	
	private static <T> T call(Supplier<T> func, Supplier<T> orElseReturn) {
		try {
			T value = func.get();
			log.info("Called value: {}", value);
			return value;
		}
		catch (HttpClientErrorException e) {
			log.error("HttpClientErrorException occurred: ", e);
			return orElseReturn.get();
		}
		catch (RuntimeException e) {
			log.error("RuntimeException occurred: ", e);
			return orElseReturn.get();
		}
	}
	
}



