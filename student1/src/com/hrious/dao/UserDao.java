package com.hrious.dao;

import java.util.List;

import com.hrious.pojo.User;

public interface UserDao {
	/**
	 * ����һ���û���Ϣ
	 * @param unum �û����(����)
	 * @param uname �û�����
	 * @param uage �û����
	 * @return Ӱ������
	 */
    int insertUser(int unum, String uname, int uage);
    /**
     * ��������ɾ��һ����¼
     * @param unum �û����(����)
     * @return Ӱ������
     */
    int delUser(int unum);
    /**
     * ��������,�����û�����
     * @param unum �û����(����)
     * @param uname �û�����
     * @return Ӱ������
     */
    int updateUserName(int unum, String uname);
    /**
     * ��ѯ�����û���Ϣ
     * @return �����û���Ϣ
     */
    List<User> selectAllUser();
    /**
     * ����ָ��������ѯ�û���Ϣ
     * @return �û���Ϣ
     */
    User selectUser(int unum);
}
