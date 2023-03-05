-- скрипт для создания бд (PostgreSQL)

DROP TABLE IF EXISTS its_post;
DROP TABLE IF EXISTS its_user;
DROP TABLE IF EXISTS its_post_comment;
DROP TABLE IF EXISTS its_post_like;

CREATE TABLE its_user
(
	user_id SERIAL PRIMARY KEY,
	user_login varchar(50) UNIQUE,
	user_password text,
	user_role varchar(50),
	avatar_url text,
	user_name varchar(50),
	about varchar(250),
	post_count integer
);

CREATE TABLE its_post
(
	post_id SERIAL PRIMARY KEY,
	post_title varchar(100),
	post_preview varchar(250),
	post_text text,
	author_id integer REFERENCES its_user (user_id),
	post_status integer,
	published date,
	created date
);

CREATE TABLE its_post_comment 
(
	comment_id SERIAL PRIMARY KEY,
	author_id integer REFERENCES its_user (user_id),
	created date,
	comment_text text,
	post_id integer REFERENCES its_post (post_id)
);

CREATE TABLE its_post_like 
(
	like_id SERIAL PRIMARY KEY,
	author_id integer REFERENCES its_user (user_id),
	post_id integer REFERENCES its_post (post_id)
);