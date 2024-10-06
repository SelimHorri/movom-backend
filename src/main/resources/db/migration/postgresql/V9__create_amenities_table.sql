create table if not exists amenities (
    id bigserial primary key,
    uid uuid,
    name varchar(255),
    description varchar(255),
    accomodation_id bigint,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);