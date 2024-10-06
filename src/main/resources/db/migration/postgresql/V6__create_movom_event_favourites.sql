create table if not exists movom_event_favourites (
    id bigserial primary key,
    uid uuid,
    favoured_at timestamp,
    actor_id bigint,
    movom_event_id bigint,
    created_at timestamp,
    created_by varchar(255),
    updated_at timestamp,
    updated_by varchar(255)
);