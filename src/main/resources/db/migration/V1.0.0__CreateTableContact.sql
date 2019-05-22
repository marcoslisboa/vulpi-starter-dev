CREATE TABLE t_contact
(
    id         bigserial NOT NULL PRIMARY KEY,
    created_at timestamp,
    deleted    boolean DEFAULT FALSE NOT NULL,
    updated_at timestamp,
    birthday   timestamp,
    email      varchar(255),
    job        varchar(255),
    name       varchar(255),
    notes      varchar(255),
    phone      varchar(255),
    status     varchar(255)

);

