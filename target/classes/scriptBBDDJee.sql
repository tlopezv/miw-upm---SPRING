/**

-- Arrancamos nuestra imagen Docker con MySQL: Container "my-mysql" sobre el puerto 3307
-- Y conectamos con el usuario "root"

sh -4.4 # mysql -u root -p
Enter password admin

-- Comprobamos todos los usuarios creados:

mysql> SELECT user,host FROM mysql.user;
+------------------+-----------+
| user             | host      |
+------------------+-----------+
| UskoKruM2010     | %         |
| bytecode         | %         |
| luigicode        | %         |
| root             | %         |
| springbootuser   | %         |
| springroot       | %         |
| todotic          | %         |
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| root             | localhost |
+------------------+-----------+
11 rows in set (0.00 sec)

-- Y creamos el usuario Para este Tutorial de miw-upm: https://www.youtube.com/watch?v=M92drhxRFmA&list=PLj2IVmcP-_QOZEVxc-wAOoZjH5ZMmt6fs&index=2
-- Usuario: miw-upm
-- Contraseña: 1234

mysql> CREATE USER 'miw-upm'@'%' IDENTIFIED BY '1234';
Query OK, 0 rows affected (0.02 sec)

-- Creamos la Base de Datos 'jee'

mysql> CREATE DATABASE IF NOT EXISTS jee;
Query OK, 1 row affected (0.01 sec)

-- Le damos todos los privilegios (permitimos hacer cualquier acción) al usuario 'miw - upm' sober la Base de Datos 'jee'

mysql> GRANT ALL PRIVILEGES ON jee.* TO 'miw-upm'@'%';
Query OK, 0 rows affected (0.00 sec)

-- Nos aseguramos de volver a cargar de nuevo todos los privilegios, para que se tengan en cuenta los recién creados.

mysql > FLUSH PRIVILEGES;
Query OK, 0 rows affected (0.00 sec)

-- Volvermos a comprobar todos los usuarios creados:

mysql> SELECT user,host FROM mysql.user;
+------------------+-----------+
| user             | host      |
+------------------+-----------+
| UskoKruM2010     | %         |
| bytecode         | %         |
| luigicode        | %         |
| miw-upm          | %         |
| root             | %         |
| springbootuser   | %         |
| springroot       | %         |
| todotic          | %         |
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| root             | localhost |
+------------------+-----------+
12 rows in set (0.00 sec)

-- Salimos de la sesión MySQL como usuario 'root'
mysql > quit
Bye

-- Y abrimos una nueva sesión MySQL con el usuario 'miw-upm'

sh-4.4# mysql -u miw-upm -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.0.29 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

-- Nos aseguramos de estar utilizando la Base de Datos 'blog'

mysql > USE jee;
Database changed

-- Y comprobamos en que Base de Datos estamos

mysql> STATUS;
--------------
mysql  Ver 8.0.29 for Linux on x86_64 (MySQL Community Server - GPL)

Connection id:          9
Current database:       jee
Current user:           miw-upm@localhost
SSL:                    Not in use
Current pager:          stdout
Using outfile:          ''
Using delimiter:        ;
Server version:         8.0.29 MySQL Community Server - GPL
Protocol version:       10
Connection:             Localhost via UNIX socket
Server characterset:    utf8mb4
Db     characterset:    utf8mb4
Client characterset:    latin1
Conn.  characterset:    latin1
UNIX socket:            /var/run/mysqld/mysqld.sock
Binary data as:         Hexadecimal
Uptime:                 6 min 37 sec

Threads: 2  Questions: 17  Slow queries: 0  Opens: 169  Flush tables: 3  Open tables: 88  Queries per second avg: 0.042
--------------

-- Comprobamos que Bases de Datos tenemos:

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| jee                |
+--------------------+
2 rows in set (0.00 sec)

**/