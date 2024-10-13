package tn.movom.app.movom.domain;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Accomodation(UUID uid,
						   String title,
						   String fullAddress,
						   String zipcode,
						   String countryDialCode,
						   String ownerName,
						   Integer numberOfRooms,
						   String description,
						   Actor actor) {}



