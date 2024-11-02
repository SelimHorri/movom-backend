package tn.movom.app.infra.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import tn.movom.app.movom.infrastructure.client.CountryHttpClient;
import tn.movom.app.movom.infrastructure.props.MovomExternalApiProps;

import java.util.Arrays;

@Configuration(proxyBeanMethods = false)
class HttpClientsConfig {
	
	@Primary
	@Bean
	RestClient restClient(RestClient.Builder restClientBuilder) {
		return restClientBuilder
				.requestFactory(new JdkClientHttpRequestFactory())
				.build();
	}
	
	@Bean
	RestClient restfulCountriesRestClient(RestClient restClient, MovomExternalApiProps movomExternalApiProps) {
		var api = movomExternalApiProps.externalApis().stream()
				.filter(externalApi -> ExternalApiNames.existsByName(externalApi.name()))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(
						"No external api registered, only registered are: " + Arrays.toString(ExternalApiNames.values())));
		
		var bearer = "Bearer" + StringUtils.SPACE;
		return restClient.mutate()
				.baseUrl(api.baseUrl())
				.defaultHeader(HttpHeaders.AUTHORIZATION, bearer + api.accessToken())
				.build();
	}
	
	@Bean
	CountryHttpClient countryHttpClient(@Qualifier("restfulCountriesRestClient") RestClient restClient) {
		return HttpServiceProxyFactory.builder()
				.exchangeAdapter(RestClientAdapter.create(restClient))
				.build()
				.createClient(CountryHttpClient.class);
	}
	
}

@RequiredArgsConstructor
@Getter
enum ExternalApiNames {
	
	RESTFULCOUNTRIES("restfulcountries");
	
	private final String name;
	
	public static boolean existsByName(String name) {
		return Arrays.stream(ExternalApiNames.values())
				.map(ExternalApiNames::getName)
				.anyMatch(value -> value.equalsIgnoreCase(name));
	}
	
}



