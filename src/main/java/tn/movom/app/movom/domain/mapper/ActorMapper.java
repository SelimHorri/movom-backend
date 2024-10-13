package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.Actor;
import tn.movom.app.movom.domain.Credential;
import tn.movom.app.movom.domain.UserRoleBasedAuthority;
import tn.movom.app.movom.domain.entity.ActorEntity;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ActorMapper {
	
	public static Actor from(ActorEntity actor) {
		return Actor.builder()
				.uid(actor.getUid())
				.ssn(actor.getSsn())
				.isVerified(actor.getIsVerified())
				.firstname(actor.getFirstname())
				.lastname(actor.getLastname())
				.email(actor.getEmail())
				.selfDescription(actor.getSelfDescription())
				.phone(actor.getPhone())
				.countryDialCode(actor.getCountryDialCode())
				.speakingLangs(
						actor.getSpeakingLangs().lines()
								.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
								.collect(Collectors.toUnmodifiableSet()))
				.jobTitle(actor.getJobTitle())
				.joinedAt(actor.getJoinedAt())
				.credential(Credential.builder()
						.uid(actor.getCredential().getUid())
						.username(actor.getCredential().getUsername())
						.password(actor.getCredential().getPassword())
						.roles(
								actor.getCredential().getRoles().lines()
										.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
										.map(UserRoleBasedAuthority::findByAuthority)
										.collect(Collectors.toUnmodifiableSet()))
						.isEnabled(actor.getCredential().getIsEnabled())
						.isAccountNonExpired(actor.getCredential().getIsAccountNonExpired())
						.isAccountNonLocked(actor.getCredential().getIsAccountNonLocked())
						.isCredentialsNonExpied(actor.getCredential().getIsCredentialsNonExpired())
						.build())
				.build();
	}
	
}



