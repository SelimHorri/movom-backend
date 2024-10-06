create table if not exists sports (
    id bigserial primary key,
    uid uuid,
    name varchar(255),
    competition_name varchar(255),
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);