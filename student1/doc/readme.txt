����ѧ����Ϣ����ϵͳ

��Ҫ����:
    1.�û����ݿ���̨��ʾ�����û���Ϣ,�����뵽���ݿ���
    2.�û����ݿ���̨��ʾ�������û�������Ϣ,����������ɾ����Ӧ���û���Ϣ
    3.�û����ݿ���̨��ʾ�������û�������Ϣ,���������������û�����
    4.�û����ݿ���̨��ʾ�������û�������Ϣ,������������ѯһ����¼
    5.��ѯ�����û�����Ϣ
    
��������:
    1.eclipse
    2.jdk1.7
    3.Oracle11g
    
���jar��:
    1.log4j-1.2.17.jar
    2.ojdbc6.jar
    
���������Ϣ:
    1.��ʹ�õ���Oracle11g���ݿ�
    
        -- �������
        create table t_user(
               unum number(10) primary key,
               uname varchar2(100) not null,
               uage number(3) not null
        )
        
        -- ��������
        create sequence seq_user
        start with 1
        increment by 1
        
        -- ��������
        insert into t_user values(seq_user.nextval,'�����',18);
        insert into t_user values(seq_user.nextval,'��˽�',22);
        insert into t_user values(seq_user.nextval,'ɳ����',25);
        insert into t_user values(seq_user.nextval,'������',33);
        insert into t_user values(seq_user.nextval,'������',16);
        
    2.src/db.properties���������ݿ�������Ϣ
    