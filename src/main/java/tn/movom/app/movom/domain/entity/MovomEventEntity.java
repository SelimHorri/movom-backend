package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tn.movom.app.movom.domain.MovomEventStatus;

import java.time.LocalDateTime;
import java.util.Set;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actor_id")
	private ActorEntity actor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sport_id")
	private SportEntity sport;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private CountryEntity country;
	
	@OneToMany(mappedBy = "movomEvent", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<MovomEventFavouriteEntity> movomEventFavourites;
	
}



