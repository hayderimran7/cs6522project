# CS6522 Course Project - Bookstore

## By Muhammad Imran Malik
## NetID: wm6052

## Introduction 

This repository contains the source code for the CS6522 course project. The project is a bookstore app able to handle login,
registration and order books into each user's cart. Also allows using and adding credit cards linked with users.
  

## Steps to Run


1. Make sure Mysql is installed.

2. From mysql workbench or commandline(if you are on Mac) run the `web/initdb.sql`. This will initialize 
the db schema and create tables for book, users, orders and insert initial data in it. 
On Mac, do it as:

```
cd web/
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

## Testing Login with test accounts

Some accounts are pre-setup by `initdb.sql` and their credentials are:  

```  
Username/passwords:  

	 root/root
	 cs6522/cs6522

```



Cheers:)


# cs6522project
