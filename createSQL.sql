begin;

create schema shop;

alter schema shop owner to postgres;

create table if not exists products
(
	id bigserial not null
		constraint products_pkey
			primary key,
	name varchar(255),
	price integer
);

alter table products owner to postgres;

create table if not exists users
(
	id bigserial not null
		constraint users_pk
			primary key,
	fio varchar(255)
);

alter table users owner to postgres;

commit;

