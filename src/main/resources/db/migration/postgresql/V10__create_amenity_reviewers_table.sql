create table if not exists amenity_reviewers (
    id bigserial primary key,
    uid uuid,
    rate varchar(255),
    reviewed_at timestamp,
    reviewer_comment varchar(255),
    amenity_id bigint,
    reviewer_id bigint,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);