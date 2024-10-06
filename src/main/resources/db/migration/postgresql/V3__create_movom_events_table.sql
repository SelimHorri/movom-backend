create table if not exists movom_events (
    id bigserial primary key,
    uid uuid,
    title varchar(255),
    status varchar(255),
    starts_at timestamp,
    ends_at timestamp,
    description varchar(255),
    full_location varchar(255),
    facility_name varchar(255),
    actor_id bigint,
    sport_id bigint,
    country_id bigint,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);