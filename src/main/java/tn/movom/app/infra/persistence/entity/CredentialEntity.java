package tn.movom.app.infra.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "credentials")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CredentialEntity extends AbstractAuditingEntity {
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String roles;
	
	@Column(nullable = false)
	private Boolean isEnabled;
	
	@Column(nullable = false)
	private Boolean isAccountNonExpired;
	
	@Column(nullable = false)
	private Boolean isAccountNonLocked;
	
	@Column(nullable = false)
	private Boolean isCredentialsNonExpired;
	
	@OneToOne(mappedBy = "credential")
	private ActorEntity actor;
	
}



