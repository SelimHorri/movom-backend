package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tn.movom.app.constant.AppConstants;
import tn.movom.app.movom.domain.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Entity
@Table(name = "movom_events")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MovomEventEntity extends AbstractAuditingEntity {
	
	@Column(nullable = false)
	private String title;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MovomEventStatus status;
	
	@Column(name = "starts_at", nullable = false)
	private LocalDateTime startsAt;
	
	@Column(name = "ends_at", nullable = false)
	private LocalDateTime endsAt;
	
	private String description;
	
	@Column(name = "full_location", nullable = false)
	private String fullLocation;
	
	@Column(name = "facility_name", nullable = false)
	private String facilityName;
	
	@ManyToOne
	@JoinColumn(name = "actor_id")
	private ActorEntity actor;
	
	@ManyToOne
	@JoinColumn(name = "sport_id")
	private SportEntity sport;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryEntity country;
	
	@OneToMany(mappedBy = "movomEvent", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<MovomEventFavouriteEntity> movomEventFavourites;
	
	public MovomEvent toMovomEvent() {
		return MovomEvent.builder()
				.uid(this.getUid())
				.title(this.title)
				.status(this.status)
				.startsAt(this.startsAt)
				.endsAt(this.endsAt)
				.description(this.description)
				.fullLocation(this.fullLocation)
				.facilityName(this.facilityName)
				.actor(Actor.builder()
						.uid(this.actor.getUid())
						.ssn(this.actor.getSsn())
						.isVerified(this.actor.getIsVerified())
						.firstname(this.actor.getFirstname())
						.lastname(this.actor.getLastname())
						.email(this.actor.getEmail())
						.selfDescription(this.actor.getSelfDescription())
						.phone(this.actor.getPhone())
						.countryDialCode(this.actor.getCountryDialCode())
						.speakingLangs(
								this.actor.getSpeakingLangs().lines()
										.flatMap(Pattern.compile(AppConstants.DB_STRING_SEPARATOR)::splitAsStream)
										.collect(Collectors.toUnmodifiableSet()))
						.jobTitle(this.actor.getJobTitle())
						.joinedAt(this.actor.getJoinedAt())
						// .credential(null)
						.build())
				.sport(new Sport(
						this.sport.getUid(),
						this.sport.getName(),
						this.sport.getCompetitionName()))
				.country(new Country(
						this.country.getUid(),
						this.country.getDialCode(),
						this.country.getName()))
				.build();
	}
	
}



