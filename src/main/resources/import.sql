
insert into roles (authority) values ('ROLE_ADMIN'),('ROLE_USER');
insert into users (age,email,password,name,second_name) values (25,'admin@email.ru','$2a$12$jS3ZUiRn70HhAdJI0isv5OqMTGtOebIj68xclat0QJQMzYRQdoS7G','admin','admin');
insert into users (age,email,password,name,second_name) values (28,'admin1@email.ru','$2a$10$nCAmgQcMNZn.duRCj1sV9O71J3mxapmkusGwF/1458S4QM1cmbndS','admin2','admin2');
INSERT INTO users_role (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO users_role (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO users_role (`user_id`, `role_id`) VALUES ('3', '1');
INSERT INTO users_role (`user_id`, `role_id`) VALUES ('4', '1');
INSERT INTO users_role (`user_id`, `role_id`) VALUES ('5', '2');