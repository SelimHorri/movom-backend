package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@SuperBuilder
abstract class AbstractAuditingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private UUID uid;
	
	@CreatedDate
	@Column(name = "created_at", nullable = false)
	private Instant createdAt;
	
	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;
	
	@LastModifiedDate
	@Column(name = "updated_at", nullable = false)
	private Instant updatedAt;
	
	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;
	
}

class AuditingEntityListener {
	
	@PrePersist
	void preCreation(AbstractAuditingEntity auditable) {
		auditable.setUid(UUID.randomUUID());
		
		var now = Instant.now();
		auditable.setCreatedAt(now);
		auditable.setUpdatedAt(now);
	}
	
	@PreUpdate
	void preModification(AbstractAuditingEntity auditable) {
		var now = Instant.now();
		auditable.setUpdatedAt(now);
	}
	
}



