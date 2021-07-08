insert into statuses (name) values ('public');
insert into statuses (name) values ('private');
insert into statuses (name) values ('closed');

insert into roles (name) values ('ROLE_ADMIN');
insert into roles (name) values ('ROLE_USER');

insert into authorities (authority) values ('ROLE_ADMIN');
insert into authorities (authority) values ('ROLE_USER');

insert into users (username, email, password, enabled, authority_id)
values ('admin',
        'generalroot@mail.com',
        '$2a$10$dCVBjGI1tJcyqbgm1EulfuGQ7p3.tjl1tfdAszKqWN4Epp7K7CVAe',
        true,
        (select id from authorities where authority = 'ROLE_ADMIN'));

insert into topics (name, created, user_id, status_id)
values ('Правила форума', '2021-07-08 09:29:52.000000', 1, 1);

insert into posts (name, description, created, topic_id, user_id)
VALUES ('Общие правила',
'Оскорбления других участников запрещены',
'2021-07-08 09:32:25.060000', 1, 1);
