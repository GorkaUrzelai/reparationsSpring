INSERT INTO customers (first_name, email, username, password, enabled)
VALUES ('gorka', 'gorkaurzelai2000@gmail.com', 'admin',
        '$2a$04$1phuHnQ6r8yr8qktXpuFCOzd2SimSMbsIppAU4eT2NNGRN.Twlu2K',
        0b1);
INSERT INTO customers (first_name, email, username, password, enabled)
VALUES ('gorka', 'gorkaurzelai2000@gmail.com', 'customer',
        '$2a$04$1phuHnQ6r8yr8qktXpuFCOzd2SimSMbsIppAU4eT2NNGRN.Twlu2K',
        0b1);

INSERT INTO authorities (id, authority)
VALUES (1, "ROLE_ADMIN");
INSERT INTO authorities (id, authority)
VALUES (2, "ROLE_CUSTOMER");

INSERT INTO authorities_users (customer_id, authority_id)
VALUES (1, 1);
INSERT INTO authorities_users (customer_id, authority_id)
values (2, 2);

insert into tipo_piezas(tipo_piezaid, nombre) value (1, 'Freno de disco');
insert into tipo_piezas(tipo_piezaid, nombre) value (2, 'Neumatico');
insert into tipo_piezas(tipo_piezaid, nombre) value (3, 'Luz');


insert into coches(cocheid, nombre, customerid, kilometros) VALUES (1, 'audi a3', 2, 20000);
insert into coches(cocheid, nombre, customerid, kilometros) VALUES (2, 'audi a6', 2, 20000);
insert into coches(cocheid, nombre, customerid, kilometros) VALUES (3, 'mercedes', 1, 1600);

update customers set customers.coche_preferido=1 where id=2;
/*
insert into piezas(piezaid, fecha_cambio, cocheid, tipo_piezaid) VALUES (1, null, 1, 1);*/
