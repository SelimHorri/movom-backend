package tn.movom.app.infra.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import tn.movom.app.movom.infrastructure.client.CountryHttpClient;
import tn.movom.app.movom.infrastructure.props.MovomExternalApiProps;

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
		return restClient.mutate()
				.baseUrl(movomExternalApiProps.externalApis().stream()
						.filter(externalApi -> "restfulcountries".equalsIgnoreCase(externalApi.name()))
						.map(MovomExternalApiProps.ExternalApi::baseUrl)
						.findAny()
						.orElseThrow())
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



