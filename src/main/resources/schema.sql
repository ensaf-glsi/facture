create table jdbc_users(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null,
    name varchar(100),
    email varchar(60)
);

create table jdbc_authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references jdbc_users(username)
);
create unique index ix_auth_username on jdbc_authorities (username, authority);