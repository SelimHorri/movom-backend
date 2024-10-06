alter sequence if exists credentials_id_seq
increment 5
start 50
owned by credentials.id;

alter table credentials
add constraint uk_uid_credentials unique (uid);

alter table credentials
alter column uid set default gen_random_uuid();

alter table credentials
alter column created_at set default now();

alter table credentials
alter column updated_at set default now();

alter table credentials
add constraint uk_username_credentials unique (username);