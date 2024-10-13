package tn.movom.app.movom.infrastructure.client;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
record CountryNetworkInfo(String name,
						  String fullName,
						  String capital,
						  String iso2,
						  String iso3,
						  String currency,
						  String phoneCode,
						  String continent,
						  String description,
						  String size,
						  String independenceDate,
						  String population) {}



