package tn.movom.app.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "sports")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class SportEntity extends AbstractAuditingEntity {
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "competition_name")
	private String competitionName;
	
	@OneToMany(mappedBy = "sport", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<MovomEventEntity> movomEvents;
	
	@OneToMany(mappedBy = "sport", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<SportFavouriteEntity> sportFavourites;
	
}



