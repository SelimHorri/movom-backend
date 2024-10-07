package tn.movom.app.movom.domain;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public record Credential(UUID uid,
						 String username,
						 String password,
						 Set<String> roles,
						 Boolean isEnabled,
						 Boolean isAccountNonExpired,
						 Boolean isAccountNonBlocked,
						 Boolean isCredentialsNonExpied) {
	
	public Credential {
		roles = Set.copyOf(Objects.requireNonNullElseGet(roles, Set::of));
	}
	
}



