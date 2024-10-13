package tn.movom.app.movom.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record AmenityReviewer(UUID uid,
							  RatingValue rate,
							  LocalDateTime reviewedAt,
							  String reviewerComment,
							  Amenity amenity,
							  Actor actor) {}



