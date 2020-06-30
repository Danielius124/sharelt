
insert into users(id, email, password)
values (10001, 'Petras@gmail.com', 'kads132');

insert into users(id, email, password)
values (1002, 'Lukas@gmail.com', 'kiskis');

insert into user_details(id, first_name, last_name, birth_date, phone_number, country, city, user_id)
values(1001, 'Petras', 'Petrauskas', '1998-11-11', '+37061425111', 'Lietuva', 'Vilnius', 10001);

insert into items(id, item_name, description, item_value, deposit, user_id)
values(1001, 'Automobilis', 'Puikiai vaziuojantis automobilis', 500.25, 25.50, 10001);

insert into items(id, item_name, description, item_value, deposit, user_id)
values(1002, 'Riedis', 'Puikiai vaziuojantis riedis', 241.25, 20.50, 10001);

insert into items(id, item_name, description, item_value, deposit, user_id)
values(1003, 'Riedis', 'Puikiai vaziuojantis riedutis', 200.25, 15.50, 10001);

insert into items(id, item_name, description, item_value, deposit, user_id)
values(1004, 'Briedis', 'Puikiai vaziuojantis Briedis', 1564654165.25, 25.50, 10001);

insert into ITEM_PRICES(id, minimum_days, day_price, item_id)
values (1, 3, 10, 1004);

insert into ITEM_PRICES(id, minimum_days, day_price, item_id)
values (2, 7, 8, 1003);


insert into item_non_availability(id, begin_date, end_date, item_id)
values (1, '2019-01-20', '2019-12-20', 1003);

insert into item_non_availability(id, begin_date, end_date, item_id)
values (2, '2020-01-20', '2020-12-20', 1003);

insert into item_rental(id, created, cost, rent_begin, rent_end, is_confirmed, renter_id)
values (1, '2020-06-29', 1564.63551, '2020-06-29', '2020-06-29', 'false', 1002);