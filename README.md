# CS6522 Course Project - Bookstore

## By Muhammad Malik

## Introduction 

This repository contains the source code for the CS6522 course project. The project is a bookstore app able to handle login,
registration and order books into each user's cart. 
  

## Steps to Run


1. Make sure Mysql is installed.

2. From mysql workbench or commandline(if you are on Mac) run the initdb.sql. This will initialize 
the db schema and create tables for book, users, orders and insert initial data in it. 
On Mac, do it as:

```
cd projectbookstore/web/
mysql -u root
mysql> source initdb.sql 
mysql> exit
```


3. Install netbeans(if havent already)

4. Create a Project in Netbeans

5. Copy all files to that Netbeans project workspace. i.e. the web folder to your skeleton project web folder, the src folder to your project src folder.

6. Update the mysql server credentials. You would update it in:
`src/java/dbconnector.java`

7. Add JDBC mysql connector library to your netbeans project

8. Build and run. It should open the index.jsp 

9. Try logging in with init user accounts which were already created by initdb.sql in Step 2. 
Some users to log in with username/password are:
root/root
CS6522/CS6522
csueb/csueb
test/test


Cheers:)


# cs6522project
