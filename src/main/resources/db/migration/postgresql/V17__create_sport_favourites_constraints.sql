alter sequence if exists sport_favourites_id_seq
increment 5
start 50
owned by sport_favourites.id;

alter table sport_favourites
add constraint uk_uid_sport_favourites unique (uid);

alter table sport_favourites
alter column uid set default gen_random_uuid();

alter table sport_favourites
alter column created_at set default now();

alter table sport_favourites
alter column updated_at set default now();

alter table sport_favourites
add constraint uk_actor_id_sport_favourites unique (actor_id);

alter table sport_favourites
add constraint uk_sport_id_sport_favourites unique (sport_id);