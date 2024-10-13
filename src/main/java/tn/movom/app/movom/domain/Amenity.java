package tn.movom.app.movom.domain;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Amenity(UUID uid, String name, String description, Accomodation accomodation) {}



