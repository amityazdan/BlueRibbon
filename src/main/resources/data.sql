DROP ALL OBJECTS;

CREATE TABLE ticket
(
  id        INT AUTO_INCREMENT PRIMARY KEY,
  available boolean
);


CREATE TABLE destination
(
  id   INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL

);

CREATE TABLE baggage
(
  id          INT AUTO_INCREMENT PRIMARY KEY,
  baggage_id   VARCHAR(250) NOT NULL,
  checkin     boolean,
  destination INT references destination (id)
);

CREATE TABLE coupon
(
  id   INT AUTO_INCREMENT PRIMARY KEY,
  valid boolean
);

INSERT INTO ticket (available)
VALUES (false),
       (true);

INSERT INTO destination (name)
VALUES ('Paris'),
       ('Rome'),
       ('Dubai');

INSERT INTO baggage (baggage_id, checkin, destination)
VALUES ('qwer', false, 1),
       ('asdf', true, 2);

INSERT INTO coupon (valid)
VALUES (true),
       (false),
       (false),
       (true);
