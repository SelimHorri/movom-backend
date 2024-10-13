package tn.movom.app.movom.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum UserRoleBasedAuthority {
	
	GUIDE("ROLE_GUIDE"),
	HOST("ROLE_HOST"),
	ADMIN("ROLE_ADMIN");
	
	private final String authority;
	
	public static UserRoleBasedAuthority findByAuthority(String authority) {
		return Arrays.stream(UserRoleBasedAuthority.values())
				.filter(value -> value.name().equalsIgnoreCase(authority))
				.findFirst()
				.orElseThrow();
	}
	
}



