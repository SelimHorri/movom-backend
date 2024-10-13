package tn.movom.app.movom.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.Credential;
import tn.movom.app.movom.domain.UserRoleBasedAuthority;
import tn.movom.app.movom.domain.entity.CredentialEntity;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CredentialMapper {
	
	public static Credential from(CredentialEntity credential) {
		return Credential.builder()
				.uid(credential.getUid())
				.username(credential.getUsername())
				.password(credential.getPassword())
				.roles(
						credential.getRoles().lines()
								.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
								.map(UserRoleBasedAuthority::findByAuthority)
								.collect(Collectors.toUnmodifiableSet()))
				.isEnabled(credential.getIsEnabled())
				.isAccountNonExpired(credential.getIsAccountNonExpired())
				.isAccountNonLocked(credential.getIsAccountNonLocked())
				.isCredentialsNonExpied(credential.getIsCredentialsNonExpired())
				.build();
	}
	
}



