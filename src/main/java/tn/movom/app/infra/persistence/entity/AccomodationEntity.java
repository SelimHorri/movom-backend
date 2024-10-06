package tn.movom.app.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "accomodations")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class AccomodationEntity extends AbstractAuditingEntity {
	
	@Column(nullable = false)
	private String title;
	
	@Column(name = "full_address", nullable = false)
	private String fullAddress;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "country_dial_code", nullable = false)
	private String countryDialCode;
	
	@Column(name = "owner_name", nullable = false)
	private String ownerName;
	
	@Column(name = "number_of_rooms", nullable = false)
	private Integer numberOfRooms;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "actor_id")
	private ActorEntity actor;
	
	@OneToMany(mappedBy = "accomodation", orphanRemoval = true, cascade = CascadeType.ALL)
	private Set<AmenityEntity> amenities;
	
}



