package tn.movom.app.movom.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record SportFavourite(UUID uid, LocalDateTime favouredAt, Actor actor, Sport sport) {}



