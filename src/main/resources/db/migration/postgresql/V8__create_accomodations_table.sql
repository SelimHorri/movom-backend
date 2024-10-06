create table if not exists accomodations (
    id bigserial primary key,
    uid uuid,
    title varchar(255),
    full_address varchar(255),
    zipcode varchar(255),
    country_dial_code varchar(255),
    owner_name varchar(255),
    number_of_rooms integer,
    description varchar(255),
    actor_id bigint,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);