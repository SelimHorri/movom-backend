create table if not exists sport_favourites (
    id bigserial primary key,
    uid uuid,
    favoured_at timestamp,
    actor_id bigint,
    sport_id bigint,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);