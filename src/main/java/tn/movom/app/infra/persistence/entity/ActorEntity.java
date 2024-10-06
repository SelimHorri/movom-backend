package tn.movom.app.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "actors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ActorEntity extends AbstractAuditingEntity {
	
	@Column(nullable = false, unique = true)
	private String ssn;
	
	@Column(name = "is_verified", nullable = false)
	private Boolean isVerified;
	
	@Column(nullable = false)
	private String firstname;
	
	@Column(nullable = false)
	private String lastname;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(name = "self_description")
	private String selfDescription;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(name = "country_dial_code")
	private String countryDialCode;
	
	@Column(name = "speaking_langs")
	private String speakingLangs;
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "joined_at")
	private LocalDate joinedAt;
	
	@OneToOne
	@JoinColumn(name = "credential_id")
	private CredentialEntity credential;
	
	@OneToMany(mappedBy = "actor", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<MovomEventEntity> movomEvents;
	
	@OneToMany(mappedBy = "actor", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SportFavouriteEntity> sportFavourites;
	
	@OneToMany(mappedBy = "actor", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<MovomEventFavouriteEntity> movomEventFavourites;
	
	@OneToMany(mappedBy = "actor", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<AccomodationEntity> accomodations;
	
	@OneToMany(mappedBy = "reviewer")
	private Set<AmenityReviewerEntity> amenityReviewers;
	
}



