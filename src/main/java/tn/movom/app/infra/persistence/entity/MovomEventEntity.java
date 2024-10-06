package tn.movom.app.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tn.movom.app.movom.event.domain.MovomEventStatus;

import java.time.LocalDateTime;

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
	
}



