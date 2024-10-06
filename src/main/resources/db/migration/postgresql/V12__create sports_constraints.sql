alter sequence if exists sports_id_seq
increment 5
start 50
owned by sports.id;

alter table sports
add constraint uk_uid_sports unique (uid);

alter table sports
alter column uid set default gen_random_uuid();

alter table sports
alter column created_at set default now();

alter table sports
alter column updated_at set default now();