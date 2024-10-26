package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "movom_event_favourites")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class MovomEventFavouriteEntity extends AbstractAuditingEntity {
	
	@Column(name = "favoured_at", nullable = false)
	private LocalDateTime favouredAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actor_id")
	private ActorEntity actor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movom_event_id")
	private MovomEventEntity movomEvent;
	
}



