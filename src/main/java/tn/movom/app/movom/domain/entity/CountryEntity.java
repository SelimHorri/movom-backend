package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tn.movom.app.movom.domain.ContinentName;

import java.util.Set;

@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CountryEntity extends AbstractAuditingEntity {
	
	@Column(name = "dial_code", nullable = false)
	private String dialCode;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ContinentName continent;
	
	@OneToMany(mappedBy = "country")
	private Set<MovomEventEntity> movomEvents;
	
}



