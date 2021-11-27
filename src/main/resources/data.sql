insert into jdbc_users(username, password, enabled, name) values ('user', 'user', true, 'User 1');
insert into jdbc_users(username, password, enabled, name) values ('admin', 'admin', true, 'Administrateur');

insert into jdbc_authorities(username, authority) values ('user', 'USER');
insert into jdbc_authorities(username, authority) values ('admin', 'ADMIN'), ('admin', 'USER');