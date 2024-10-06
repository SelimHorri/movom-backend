alter sequence if exists movom_events_id_seq
increment 5
start 50
owned by movom_events.id;

alter table movom_events
add constraint uk_uid_movom_events unique (uid);

alter table movom_events
alter column uid set default gen_random_uuid();

alter table movom_events
alter column created_at set default now();

alter table movom_events
alter column updated_at set default now();

alter table movom_events
add constraint fk_actor_id_movom_events
foreign key (actor_id) references actors (id);

alter table movom_events
add constraint fk_sport_id_movom_events
foreign key (sport_id) references sports (id);

alter table movom_events
add constraint fk_country_id_movom_events
foreign key (country_id) references countries (id);