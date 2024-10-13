package tn.movom.app.movom.infrastructure.props;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Objects;

@ConfigurationProperties(prefix = "movom")
public record MovomExternalApiProps(List<ExternalApi> externalApis) {
	
	public MovomExternalApiProps {
		externalApis = List.copyOf(Objects.requireNonNullElseGet(externalApis, List::of));
	}
	
	public record ExternalApi(String name, String baseUrl, Boolean requiresAuthz, String accessToken) {
		
		public ExternalApi {
			if (StringUtils.isBlank(name))
				throw new IllegalArgumentException("Name of external resource is required for proper configuration");
			
			if (StringUtils.isBlank(baseUrl))
				throw new IllegalArgumentException("Base URL of %s external resource is required for proper configuration".formatted(name));
			
			requiresAuthz = Objects.requireNonNullElse(requiresAuthz, false);
			if (requiresAuthz && StringUtils.isBlank(accessToken))
				throw new IllegalArgumentException(name + " external resource requires a valid access token for proper configuration");
		}
		
	}
	
}



