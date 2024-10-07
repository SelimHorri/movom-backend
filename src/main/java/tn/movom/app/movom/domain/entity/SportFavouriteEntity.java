package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "sport_favourites")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class SportFavouriteEntity extends AbstractAuditingEntity {
	
	@Column(name = "favoured_at", nullable = false)
	private LocalDateTime favouredAt;
	
	@ManyToOne
	@JoinColumn(name = "actor_id")
	private ActorEntity actor;
	
	@ManyToOne
	@JoinColumn(name = "sport_id")
	private SportEntity sport;
	
}



