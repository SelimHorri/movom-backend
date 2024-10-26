create table if not exists countries (
    id bigserial primary key,
    uid uuid,
    dial_code varchar(255),
    name varchar(255),
    continent varchar(255),
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);