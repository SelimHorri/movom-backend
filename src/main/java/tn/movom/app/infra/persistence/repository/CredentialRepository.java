package tn.movom.app.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.movom.app.infra.persistence.entity.CredentialEntity;

import java.util.Optional;
import java.util.UUID;

public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {
	
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



