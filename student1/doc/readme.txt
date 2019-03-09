简易学生信息管理系统

主要功能:
    1.用户根据控制台提示输入用户信息,并插入到数据库中
    2.用户根据控制台提示的输入用户主键信息,并根据主键删除对应的用户信息
    3.用户根据控制台提示的输入用户主键信息,并根据主键更新用户姓名
    4.用户根据控制台提示的输入用户主键信息,并根据主键查询一条记录
    5.查询所有用户的信息
    
开发环境:
    1.eclipse
    2.jdk1.7
    3.Oracle11g
    
相关jar包:
    1.log4j-1.2.17.jar
    2.ojdbc6.jar
    
配置相关信息:
    1.我使用的是Oracle11g数据库
    
        -- 建表语句
        create table t_user(
               unum number(10) primary key,
               uname varchar2(100) not null,
               uage number(3) not null
        )
        
        -- 创建序列
        create sequence seq_user
        start with 1
        increment by 1
        
        -- 插入数据
        insert into t_user values(seq_user.nextval,'孙悟空',18);
        insert into t_user values(seq_user.nextval,'猪八戒',22);
        insert into t_user values(seq_user.nextval,'沙和尚',25);
        insert into t_user values(seq_user.nextval,'唐三藏',33);
        insert into t_user values(seq_user.nextval,'白龙马',16);
        
    2.src/db.properties中配置数据库连接信息
    