package tn.movom.app.infra.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "amenity_reviewers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class AmenityReviewerEntity extends AbstractAuditingEntity {
	
	@Enumerated(EnumType.ORDINAL)
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

@RequiredArgsConstructor
@Getter
enum RatingValue {
	
	VERY_BAD(1),
	BAD(2),
	NEUTRAL(3),
	GOOD(4),
	PERFECT(5);
	
	private final int ratingValue;
	
}



