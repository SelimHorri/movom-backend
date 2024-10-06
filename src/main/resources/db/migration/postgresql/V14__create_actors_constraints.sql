alter sequence if exists actors_id_seq
increment 5
start 50
owned by actors.id;

alter table actors
add constraint uk_uid_actors unique (uid);

alter table actors
alter column uid set default gen_random_uuid();

alter table actors
alter column created_at set default now();

alter table actors
alter column updated_at set default now();

alter table actors
add constraint uk_ssn_actors unique (ssn);

alter table actors
add constraint uk_email_actors unique (email);

alter table actors
add constraint fk_credential_id_actors
foreign key (credential_id) references credentials (id);