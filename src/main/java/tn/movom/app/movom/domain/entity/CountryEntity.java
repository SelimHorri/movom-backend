package tn.movom.app.movom.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class CountryEntity extends AbstractAuditingEntity {
	
	@Column(name = "dial_code", nullable = false, unique = true)
	private String dialCode;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "country")
	private Set<MovomEventEntity> movomEvents;
	
}



