package tn.movom.app.movom.domain;

import lombok.Builder;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Builder
public record Credential(UUID uid,
						 String username,
						 String password,
						 Set<UserRoleBasedAuthority> roles,
						 Boolean isEnabled,
						 Boolean isAccountNonExpired,
						 Boolean isAccountNonLocked,
						 Boolean isCredentialsNonExpied) {
	
	public Credential {
		roles = Set.copyOf(Objects.requireNonNullElseGet(roles, Set::of));
	}
	
}



