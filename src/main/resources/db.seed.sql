insert into chatroom (name) values ('nb');

insert into user (username) values ('Bob');
insert into user (username) values ('Kate');

insert into chatroom_users ( chatroom_id, user_id ) values (1, 1);
insert into chatroom_users ( chatroom_id, user_id ) values (1, 2);

insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'ENTER_EVT', 1, null, '2014-01-01 17:00:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'ENTER_EVT', 2, null, '2014-01-01 17:05:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'COMMENT_EVT', 1, 'Hey Kate, high five?', '2014-01-01 17:15:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'HIGH_FIVE_EVT', 2, null, '2014-01-01 17:17:00', 1);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'LEAVE_EVT', 1, null, '2014-01-01 17:18:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'COMMENT_EVT', 2, 'Oh, typical', '2014-01-01 17:20:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'LEAVE_EVT', 2, null, '2014-01-01 17:21:00', null);

insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'ENTER_EVT', 1, null, '2014-01-01 18:01:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'ENTER_EVT', 2, null, '2014-01-01 18:05:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'COMMENT_EVT', 1, 'Hey Kate, sorry I lost my internet connection.', '2014-01-01 18:10:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'COMMENT_EVT', 2, 'Ok.', '2014-01-01 18:10:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'HIGH_FIVE_EVT', 1, null, '2014-01-01 18:11:00', 2);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'HIGH_FIVE_EVT', 2, null, '2014-01-01 18:11:00', 1);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'HIGH_FIVE_EVT', 2, null, '2014-01-01 18:11:00', 1);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'HIGH_FIVE_EVT', 2, null, '2014-01-01 18:11:00', 1);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'HIGH_FIVE_EVT', 2, null, '2014-01-01 18:11:00', 1);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'HIGH_FIVE_EVT', 2, null, '2014-01-01 18:12:00', 1);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'LEAVE_EVT', 1, null, '2014-01-01 18:13:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'COMMENT_EVT', 2, 'Haha', '2014-01-01 18:14:00', null);
insert into event (chatroom_id, event_type, user_id, comment, timestamp, alt_user_id) values (1, 'LEAVE_EVT', 2, null, '2014-01-01 18:21:00', null);