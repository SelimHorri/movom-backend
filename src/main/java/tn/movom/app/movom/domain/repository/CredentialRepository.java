package tn.movom.app.movom.domain.repository;

import tn.movom.app.movom.domain.entity.CredentialEntity;

import java.util.Optional;
import java.util.UUID;

public interface CredentialRepository {
	
	Optional<CredentialEntity> findByUid(UUID uid);
	Optional<CredentialEntity> findByUsernameIgnoreCase(String username);
	
	default Optional<CredentialEntity> findByUsername(String username) {
		return findByUsernameIgnoreCase(username);
	}
	
	default CredentialEntity findByUsernameOrElseThrow(String username) {
		return findByUsernameIgnoreCase(username)
				.orElseThrow(() -> new RuntimeException(
						"Username %s is not found by ignoring case".formatted(username)));
	}
	
}



