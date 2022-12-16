insert into users (auth_id, password, nickname, activated)
values ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 1);
insert into users (auth_id, password, nickname, activated)
values ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 1);

insert into authority (authority_type, user_id)
values ('ROLE_ADMIN', 1);
insert into authority (authority_type, user_id)
values ('ROLE_USER', 1);
insert into authority (authority_type, user_id)
values ('ROLE_USER', 2);

-- insert into user_authority (user_id, authority_name) values (1, 'ROLE_USER');
-- insert into user_authority (user_id, authority_name) values (1, 'ROLE_ADMIN');
-- insert into user_authority (user_id, authority_name) values (2, 'ROLE_USER');