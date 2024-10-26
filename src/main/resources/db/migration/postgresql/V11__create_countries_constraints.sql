alter sequence if exists countries_id_seq
increment 5
start 50
owned by countries.id;

alter table countries
add constraint uk_uid_countries unique (uid);

alter table countries
alter column uid set default gen_random_uuid();

alter table countries
alter column created_at set default now();

alter table countries
alter column updated_at set default now();