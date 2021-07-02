create table statuses
(
    id serial primary key,
    name varchar(55) not null unique
);
insert into statuses (name) values ('public');
insert into statuses (name) values ('private');
insert into statuses (name) values ('closed');

CREATE TABLE roles
(
    id serial primary key,
    name  VARCHAR(50) NOT NULL UNIQUE
);
insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_USER');

create table users
(
    id serial primary key,
    username varchar(55) not null unique,
    email varchar(155) not null unique,
    password varchar(155) not null,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);

insert into users (username, email, password, enabled, authority_id)
values ('admin',
        'generalroot@mail.com',
        '$2a$10$dCVBjGI1tJcyqbgm1EulfuGQ7p3.tjl1tfdAszKqWN4Epp7K7CVAe',
        true,
        (select id from authorities where authority = 'ROLE_ADMIN'));

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
    topic_id int references topics(id)

);