/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  imalik
 * Created: Nov 17, 2017
 */

# set global options
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
# create database 
drop database if exists cs6522project;
create database cs6522project;
use cs6522project;

drop table if exists orders;
drop table if exists users;
drop table if exists book;
drop table if exists authors;
drop table if exists credit;
create table authors (
    name char(50) primary key);
create table book (
    ISBN char(50) primary key,
    title char(50) not null,
    author char(100) not null,
    publish_year char(4));
create table users (
    cid integer primary key,
    login_name char(20) not null,
    password char(20) not null,
    full_name char(50),
    phone char(20),
    constraint unique_login_name unique (login_name));
create table orders (
    oid integer NOT NULL AUTO_INCREMENT,
    ISBN char(50) not null,
    cid integer not null,
    buy_date char(15),
    primary key(oid),
    amount int,
    constraint relation
    foreign key (ISBN) references book(ISBN),
    foreign key (cid) references users(cid));

create table credit (
    id int NOT NULL AUTO_INCREMENT,
    ccid integer not null,
    cnum char (20) not null,
    ctype char (20) ,
    ccode char (20),
    primary key(id),
    foreign key (ccid) references users(cid));


# Initialize books
insert into book (
    ISBN, title, author, publish_year) values (
    '0590353403','HARRY POTTER AND THE SORCERERS STONE', 'Rowling, J.K.', '1998' );
insert into book (
    ISBN, title, author, publish_year) values (
    '0439064864','HARRY POTTER AND THE CHAMBER OF SECRETS', 'Rowling, J.K.', '1999' );
insert into book (
    ISBN, title, author, publish_year) values (
    '0439136350','HARRY POTTER AND THE PRISONER OF AZKABAN', 'Rowling, J.K.', '1999' );
insert into book (
    ISBN, title, author, publish_year) values (
    '0439139597','HARRY POTTER AND THE GOBLET OF FIRE', 'Rowling, J.K.', '1999' );
insert into book (
    ISBN, title, author, publish_year) values (
    '0747561079','Harry Potter and the Order of the Phoenix', 'Rowling, J.K.', '2000' );
insert into book (
    ISBN, title, author, publish_year) values (
    '0439784549','Harry Potter and the Half-Blood Prince', 'Rowling, J.K.', '2005' );
insert into book (
    ISBN, title, author, publish_year) values (
    '0545010225','HARRY POTTER AND THE DEATHLY HALLOWS', 'Rowling, J.K.', '2007' );

# initialize users 
insert into users (
    cid, login_name, password, full_name, phone) values (
    ( select count(*) from users as us ) + 1, 'root', 'root', 'Root User', '12345');
insert into users (
    cid, login_name, password, full_name, phone) values (
    ( select count(*) from users as us ) + 1, 'cs6522', 'cs6522', 'cs6522', 'cs6522');
insert into users (
    cid, login_name, password, full_name, phone) values (
    ( select count(*) from users as us ) + 1, 'test', 'test', 'test', '1221122');
insert into users (
    cid, login_name, password, full_name, phone) values (
    ( select count(*) from users as us ) + 1, 'csueb', 'csueb', 'csueb', '99009900');

# initialize orders
insert into orders (
    oid, ISBN, cid, buy_date, amount) values (
( select count(*) from orders as ord ) + 1,'0590353403', 1, '2017', 1);
insert into orders (
    oid, ISBN, cid, buy_date, amount) values (
( select count(*) from orders as ord ) + 1,'0545010225', 2, '2017', 2);
insert into orders (
    oid, ISBN, cid, buy_date, amount) values (
( select count(*) from orders as ord ) + 1,'0439784549', 3, '2017', 9);

