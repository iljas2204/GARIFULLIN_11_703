CREATE TABLE public.auth
(
    id bigint DEFAULT nextval('auth_id_seq'::regclass) PRIMARY KEY NOT NULL,
    user_id integer,
    cookie_value varchar(200),
    CONSTRAINT auth_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.shop_user (id)
);
INSERT INTO public.auth (id, user_id, cookie_value) VALUES (1, 1, '432fa3dd-fa41-4422-b0a6-625317bb1f21');
CREATE TABLE public.basket
(
    id bigint DEFAULT nextval('basket_id_seq'::regclass) PRIMARY KEY NOT NULL,
    user_id bigint,
    CONSTRAINT basket_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.shop_user (id)
);
INSERT INTO public.basket (id, user_id) VALUES (1, 1);
CREATE TABLE public.basket_product
(
    basket_id bigint,
    product_id bigint,
    CONSTRAINT basket_product_basket_id_fkey FOREIGN KEY (basket_id) REFERENCES public.basket (id),
    CONSTRAINT basket_product_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product (id)
);
INSERT INTO public.basket_product (basket_id, product_id) VALUES (1, 3);
INSERT INTO public.basket_product (basket_id, product_id) VALUES (1, 2);
INSERT INTO public.basket_product (basket_id, product_id) VALUES (1, 4);
INSERT INTO public.basket_product (basket_id, product_id) VALUES (1, 3);
INSERT INTO public.basket_product (basket_id, product_id) VALUES (1, 5);
INSERT INTO public.basket_product (basket_id, product_id) VALUES (1, 1);
CREATE TABLE public.product
(
    id bigint DEFAULT nextval('product_id_seq'::regclass) PRIMARY KEY NOT NULL,
    title varchar(30),
    price integer
);
INSERT INTO public.product (id, title, price) VALUES (2, 'snus2', 200);
INSERT INTO public.product (id, title, price) VALUES (1, 'snus1', 300);
INSERT INTO public.product (id, title, price) VALUES (5, 'snus5', 500);
INSERT INTO public.product (id, title, price) VALUES (3, 'snus3', 250);
INSERT INTO public.product (id, title, price) VALUES (4, 'snus4', 400);
CREATE TABLE public.shop_user
(
    id bigint DEFAULT nextval('shop_user_id_seq'::regclass) PRIMARY KEY NOT NULL,
    name varchar(30),
    password_hash varchar(200),
    age integer NOT NULL
);
INSERT INTO public.shop_user (id, name, password_hash, age) VALUES (1, 'qwerty', '$2a$10$Mk6B4CEcHifXg4dVbBBQ8ODbCeDl5qqs8umky6LVHezecIa8QsqrC', 12);