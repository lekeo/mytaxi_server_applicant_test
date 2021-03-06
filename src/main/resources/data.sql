/**
 * CREATE Script for init of DB
 */

-- Create 3 OFFLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (1, now(), false, 'OFFLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver01');

insert into driver (id, date_created, deleted, online_status, password, username) values (2, now(), false, 'OFFLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver02');

insert into driver (id, date_created, deleted, online_status, password, username) values (3, now(), false, 'OFFLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver03');


-- Create 3 ONLINE drivers

insert into driver (id, date_created, deleted, online_status, password, username) values (4, now(), false, 'ONLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver04');

insert into driver (id, date_created, deleted, online_status, password, username) values (5, now(), false, 'ONLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver05');

insert into driver (id, date_created, deleted, online_status, password, username) values (6, now(), false, 'ONLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver06');

-- Create 1 OFFLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (7,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'OFFLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver07');

-- Create 1 ONLINE driver with coordinate(longitude=9.5&latitude=55.954)

insert into driver (id, coordinate, date_coordinate_updated, date_created, deleted, online_status, password, username)
values
 (8,
 'aced0005737200226f72672e737072696e676672616d65776f726b2e646174612e67656f2e506f696e7431b9e90ef11a4006020002440001784400017978704023000000000000404bfa1cac083127', now(), now(), false, 'ONLINE',
'$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri', 'driver08');

INSERT INTO MANUFACTURER(ID, DATE_CREATED, MANUFACTURER_NAME, DATE_UPDATED) VALUES(1,  now(), 'Mercedes', now());

INSERT INTO CAR(ID, CONVERTIBLE, DATE_CREATED, ENGINE_TYPE, LICENSE_PLATE, RATING, SEAT_COUNT, MANUFACTURER, DELETED, DATE_UPDATED, USAGE_STATUS)
VALUES(1, true, now(),  'Gas', '1q2w3e', 15.0, 3, 1, false, now(), 'AVAILABLE');

INSERT INTO CAR(ID, CONVERTIBLE, DATE_CREATED, ENGINE_TYPE, LICENSE_PLATE, RATING, SEAT_COUNT, MANUFACTURER, DELETED, DATE_UPDATED, USAGE_STATUS)
VALUES(2, true, now(),  'Electric', '1q2w3e', 15.0, 4, 1, false, now(), 'AVAILABLE');

INSERT INTO CAR(ID, CONVERTIBLE, DATE_CREATED, ENGINE_TYPE, LICENSE_PLATE, RATING, SEAT_COUNT, MANUFACTURER, DELETED, DATE_UPDATED, USAGE_STATUS)
VALUES(3, false, now(),  'Gas', '1q2w3e', 15.0, 6, 1,false, now(), 'NOT_AVAILABLE');