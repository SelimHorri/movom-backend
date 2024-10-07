package tn.movom.app.movom.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import tn.movom.app.movom.domain.RatingValue;

import java.time.LocalDateTime;

@Entity
@Table(name = "amenity_reviewers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class AmenityReviewerEntity extends AbstractAuditingEntity {
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RatingValue rate;
	
	@Column(name = "reviewed_at", nullable = false)
	private LocalDateTime reviewedAt;
	
	@Column(name = "reviewer_comment")
	private String reviewerComment;
	
	@ManyToOne
	@JoinColumn(name = "amenity_id")
	private AmenityEntity amenity;
	
	@ManyToOne
	@JoinColumn(name = "reviewer_id")
	private ActorEntity reviewer;
	
}



