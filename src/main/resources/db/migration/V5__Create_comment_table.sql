create table comment
(
	id bigint auto_increment,
	parent_id bigint not null,
	type integer not null,
	commentator bigint not null,
	gmt_create bigint not null,
	gmt_modified bigint,
	like_count bigint default 0,
	constraint table_name_pk
		primary key (id)
);