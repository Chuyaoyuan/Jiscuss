drop table if exists staff;
CREATE TABLE staff(
id INTEGER not null primary key,
name char(20),
age INTEGER
);

drop table if exists users;
CREATE TABLE users(
id INTEGER not null primary key auto_increment,
username varchar(20),
realname varchar(20),
email varchar(20),
password varchar(20),
join_time datetime,
age INTEGER,
gender char(20),
phone char(20),
discussions_count INTEGER,
comments_count INTEGER,
last_seen_time  datetime,
flag INTEGER,
level INTEGER
);

drop table if exists discussions;
CREATE TABLE discussions(
id INTEGER  not null  primary key auto_increment,
title varchar(200),
content text,
comments_count INTEGER,
participants_count INTEGER,
number_index INTEGER,
start_time datetime,
start_user_id INTEGER,
start_post_id INTEGER,
last_time datetime,
last_user_id INTEGER,
last_post_id INTEGER,
last_post_number INTEGER,
is_approved INTEGER,
like_count  INTEGER,
ip_address varchar(200),
create_id INTEGER,
create_time datetime
);

drop table if exists discussionstags;
CREATE TABLE discussionstags(
discussion_id INTEGER not null ,
tag_id INTEGER
);

drop table if exists posts;
CREATE TABLE posts(
id INTEGER not null primary key auto_increment ,
discussion_id INTEGER,
number INTEGER,
time datetime,
user_id INTEGER,
type varchar(20),
content text,
edit_time datetime,
edit_user_id INTEGER,
ip_address varchar(200),
copyright varchar(200),
is_approved INTEGER,
create_id INTEGER,
create_time datetime
);

drop table if exists settings;
CREATE TABLE settings(
key varchar(20) primary key,
value text
);

drop table if exists tags;
CREATE TABLE tags(
id INTEGER not null primary key auto_increment,
name varchar(200),
description varchar(200),
color varchar(200),
position INTEGER,
parent_id INTEGER,
discussions_count text,
last_time datetime,
last_discussion_id INTEGER,
create_id INTEGER,
create_time datetime
);