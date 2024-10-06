alter sequence if exists amenities_id_seq
increment 5
start 50
owned by amenities.id;

alter table amenities
add constraint uk_uid_amenities unique (uid);

alter table amenities
alter column uid set default gen_random_uuid();

alter table amenities
alter column created_at set default now();

alter table amenities
alter column updated_at set default now();

alter table amenities
add constraint fk_accomodation_id_amenities
foreign key (accomodation_id) references accomodations (id);