package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "amenities")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class AmenityEntity extends AbstractAuditingEntity {
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accomodation_id")
	private AccomodationEntity accomodation;
	
	@OneToMany(mappedBy = "amenity")
	private Set<AmenityReviewerEntity> amenityReviewers;
	
}



