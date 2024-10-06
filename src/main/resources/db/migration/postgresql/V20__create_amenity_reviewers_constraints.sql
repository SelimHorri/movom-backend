alter sequence if exists amenity_reviewers_id_seq
increment 5
start 50
owned by amenity_reviewers.id;

alter table amenity_reviewers
add constraint uk_uid_amenity_reviewers unique (uid);

alter table amenity_reviewers
alter column uid set default gen_random_uuid();

alter table amenity_reviewers
alter column created_at set default now();

alter table amenity_reviewers
alter column updated_at set default now();

alter table amenity_reviewers
add constraint fk_amenity_id_amenity_reviewers
foreign key (amenity_id) references amenities (id);


alter table amenity_reviewers
add constraint fk_reviewer_id_amenity_reviewers
foreign key (reviewer_id) references actors (id);