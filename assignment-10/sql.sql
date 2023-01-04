CREATE TABLE utp10.groups_users (
	group_id INT PRIMARY KEY,
	user_login INT 
);

CREATE TABLE  utp10.groups (
	group_id INT PRIMARY KEY,
	group_name VARCHAR(100),
        group_description VARCHAR(100),
        FOREIGN KEY (group_id) REFERENCES groups_users(group_id)
);

CREATE TABLE  utp10.users (
	user_login INT PRIMARY KEY,
	user_password VARCHAR(100),
	FOREIGN KEY (user_login) REFERENCES groups_users(user_login)
);

INSERT INTO utp10.groups
(group_id, group_name, group_description)
values (1, 'class_13', 'mathimatics');
INSERT INTO utp10.groups
(group_id, group_name, group_description)
values (2, 'class_15', 'russian');
INSERT INTO utp10.groups
(group_id, group_name, group_description)
values (3, 'class_17', 'programming');
INSERT INTO utp10.groups
(group_id, group_name, group_description)
values (4, 'class_20', 'english');
INSERT INTO utp10.users
(user_login, user_password)
values (123, 'password123');
INSERT INTO utp10.users
(user_login, user_password)
values (126, 'password125');
INSERT INTO utp10.users
(user_login, user_password)
values (128, 'password129');


INSERT INTO utp10.groups_user
(group_id, user_login)
values (2, 123);
INSERT INTO utp10.groups_user
(group_id, user_login)
values (1, 126);
INSERT INTO utp10.groups_user
(group_id, user_login)
values (3, 126);