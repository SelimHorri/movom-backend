alter sequence if exists accomodations_id_seq
increment 5
start 50
owned by accomodations.id;

alter table accomodations
add constraint uk_uid_accomodations unique (uid);

alter table accomodations
alter column uid set default gen_random_uuid();

alter table accomodations
alter column created_at set default now();

alter table accomodations
alter column updated_at set default now();

alter table accomodations
add constraint fk_actor_id_accomodations
foreign key (actor_id) references actors (id);