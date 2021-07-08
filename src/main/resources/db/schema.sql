create table statuses
(
    id serial primary key,
    name varchar(55) not null unique
);

CREATE TABLE roles
(
    id serial primary key,
    name  VARCHAR(50) not null unique
);

CREATE TABLE authorities
(
    id serial primary key,
    authority  VARCHAR(50) not null unique
);

create table users
(
    id serial primary key,
    username varchar(55) not null unique,
    email varchar(155) not null unique,
    password varchar(155) not null,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);

create table topics
(
    id serial primary key,
    name varchar(155) not null ,
    created timestamp without time zone not null,
    user_id int references users(id),
    status_id int references statuses(id) not null
);

create table posts
(
    id serial primary key,
    name varchar(155) not null,
    description text not null ,
    created timestamp without time zone not null,
    topic_id int references topics(id),
    user_id int references users(id)
);
