package tn.movom.app.movom.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.movom.app.movom.domain.entity.CredentialEntity;
import tn.movom.app.movom.domain.repository.CredentialRepository;

import java.util.Optional;
import java.util.UUID;

public interface CredentialJpaRepository extends JpaRepository<CredentialEntity, Long> {
	
	Optional<CredentialEntity> findByUid(UUID uid);
	Optional<CredentialEntity> findByUsernameIgnoreCase(String username);
	
}

@Repository
@RequiredArgsConstructor
class JpaCredentialRepository implements CredentialRepository {
	
	private final CredentialJpaRepository credentialJpaRepository;
	
	@Override
	public Optional<CredentialEntity> findByUid(UUID uid) {
		return this.credentialJpaRepository.findByUid(uid);
	}
	
	@Override
	public Optional<CredentialEntity> findByUsernameIgnoreCase(String username) {
		return this.credentialJpaRepository.findByUsernameIgnoreCase(username);
	}
	
}



