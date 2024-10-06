create table if not exists credentials (
    id bigserial primary key,
    uid uuid,
    username varchar(255),
    password varchar(255),
    roles varchar(255),
    is_enabled boolean,
    is_account_non_expired boolean,
    is_account_non_locked boolean,
    is_credentials_non_expired boolean,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);