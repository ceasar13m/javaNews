create table news
(
    id        bigserial primary key,
    title     varchar(250) not null,
    content   text         not null,
    date      timestamp    not null,
    published bool         not null,
    photo     varchar(250) not null
);
