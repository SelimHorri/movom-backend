package tn.movom.app.movom.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record MovomEvent(UUID uid,
						 String title,
						 MovomEventStatus status,
						 LocalDateTime startsAt,
						 LocalDateTime endsAt,
						 String description,
						 String fullLocation,
						 String facilityName,
						 Actor actor,
						 Sport sport,
						 Country country) {}



