--�û�����
use mysql;

--�鿴
select host,user,password from user ;

--����
create user xpf IDENTIFIED by 'xpf';

--�鿴�û�Ȩ��
show grants for xpf;

--����Ȩ��
grant select,update,delete,insert on testdb.*  to xpf;

--grant �������޸ġ�ɾ�� MySQL ���ݱ�ṹȨ�ޡ�

grant create on testdb.* to xpf;

grant alter on testdb.* to xpf;

grant drop on testdb.* to xpf;

--grant ���� MySQL ���Ȩ�ޡ�

grant references on testdb.* to xpf;

--grant ���� MySQL ��ʱ��Ȩ�ޡ�

grant create temporary tables on testdb.* to xpf;

--grant ���� MySQL ����Ȩ�ޡ�

grant index on testdb.* to xpf;

--grant ���� MySQL ��ͼ���鿴��ͼԴ���� Ȩ�ޡ�

grant create view on testdb.* to xpf;

grant show view on testdb.* to xpf;

--grant ���� MySQL �洢���̡����� Ȩ�ޡ�

grant create routine on testdb.* to xpf; -- now, can show procedure status

grant alter routine on testdb.* to xpf; -- now, you can drop a procedure

grant execute on testdb.* to xpf;

--grant ��ͨ DBA ����ĳ�� MySQL ���ݿ��Ȩ�ޡ�

grant all privileges on testdb to dba@��localhost��--���У��ؼ��� ��privileges�� ����ʡ�ԡ�

--grant �߼� DBA ���� MySQL ���������ݿ��Ȩ�ޡ�

grant all on *.* to dba@��localhost��

--MySQL grant Ȩ�ޣ��ֱ���������ڶ������ϡ�

--grant ���������� MySQL �������ϣ�

grant select on *.* to dba@localhost; -- dba ���Բ�ѯ MySQL ���������ݿ��еı�

grant all on *.* to dba@localhost; -- dba ���Թ��� MySQL �е��������ݿ�

--grant �����ڵ������ݿ��ϣ�

grant select on testdb.* to dba@localhost; -- dba ���Բ�ѯ testdb �еı�

--grant �����ڵ������ݱ��ϣ�

grant select, insert, update, delete on testdb.orders to dba@localhost;

--grant �����ڱ��е����ϣ�

grant select(id, se, rank) on testdb.apache_log to dba@localhost;

--grant �����ڴ洢���̡������ϣ�

grant execute on procedure testdb.pr_add to ��dba��@��localhost��;

grant execute on function testdb.fn_add to ��dba��@��localhost��;

--ע�⣺�޸���Ȩ���Ժ� һ��Ҫˢ�·��񣬻�����������ˢ�·����ã�FLUSH PRIVILEGES��
flush  privileges ;








