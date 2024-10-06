alter sequence if exists movom_event_favourites_id_seq
increment 5
start 50
owned by movom_event_favourites.id;

alter table movom_event_favourites
add constraint uk_uid_movom_event_favourites unique (uid);

alter table movom_event_favourites
alter column uid set default gen_random_uuid();

alter table movom_event_favourites
alter column created_at set default now();

alter table movom_event_favourites
alter column updated_at set default now();

alter table movom_event_favourites
add constraint fk_actor_id_movom_event_favourites
foreign key (actor_id) references actors (id);

alter table movom_event_favourites
add constraint fk_movom_event_id_id_movom_event_favourites
foreign key (movom_event_id) references movom_events (id);