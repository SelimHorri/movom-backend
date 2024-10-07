package tn.movom.app.movom.domain;

import lombok.Builder;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Builder
public record Actor(UUID uid,
					String ssn,
					Boolean isVerified,
					String firstname,
					String lastname,
					String email,
					String selfDescription,
					String phone,
					String countryDialCode,
					Set<String> speakingLangs,
					String jobTitle,
					LocalDate joinedAt,
					Credential credential) {
	
	public Actor {
		speakingLangs = Set.copyOf(Objects.requireNonNullElseGet(speakingLangs, Set::of));
	}
	
}



