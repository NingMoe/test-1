--用户管理
use mysql;

--查看
select host,user,password from user ;

--创建
create user xpf IDENTIFIED by 'xpf';

--查看用户权限
show grants for xpf;

--赋予权限
grant select,update,delete,insert on testdb.*  to xpf;

--grant 创建、修改、删除 MySQL 数据表结构权限。

grant create on testdb.* to xpf;

grant alter on testdb.* to xpf;

grant drop on testdb.* to xpf;

--grant 操作 MySQL 外键权限。

grant references on testdb.* to xpf;

--grant 操作 MySQL 临时表权限。

grant create temporary tables on testdb.* to xpf;

--grant 操作 MySQL 索引权限。

grant index on testdb.* to xpf;

--grant 操作 MySQL 视图、查看视图源代码 权限。

grant create view on testdb.* to xpf;

grant show view on testdb.* to xpf;

--grant 操作 MySQL 存储过程、函数 权限。

grant create routine on testdb.* to xpf; -- now, can show procedure status

grant alter routine on testdb.* to xpf; -- now, you can drop a procedure

grant execute on testdb.* to xpf;

--grant 普通 DBA 管理某个 MySQL 数据库的权限。

grant all privileges on testdb to dba@’localhost’--其中，关键字 “privileges” 可以省略。

--grant 高级 DBA 管理 MySQL 中所有数据库的权限。

grant all on *.* to dba@’localhost’

--MySQL grant 权限，分别可以作用在多个层次上。

--grant 作用在整个 MySQL 服务器上：

grant select on *.* to dba@localhost; -- dba 可以查询 MySQL 中所有数据库中的表。

grant all on *.* to dba@localhost; -- dba 可以管理 MySQL 中的所有数据库

--grant 作用在单个数据库上：

grant select on testdb.* to dba@localhost; -- dba 可以查询 testdb 中的表。

--grant 作用在单个数据表上：

grant select, insert, update, delete on testdb.orders to dba@localhost;

--grant 作用在表中的列上：

grant select(id, se, rank) on testdb.apache_log to dba@localhost;

--grant 作用在存储过程、函数上：

grant execute on procedure testdb.pr_add to ’dba’@’localhost’;

grant execute on function testdb.fn_add to ’dba’@’localhost’;

--注意：修改完权限以后 一定要刷新服务，或者重启服务，刷新服务用：FLUSH PRIVILEGES。
flush  privileges ;








