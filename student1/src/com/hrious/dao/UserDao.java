package com.hrious.dao;

import java.util.List;

import com.hrious.pojo.User;

public interface UserDao {
	/**
	 * 插入一条用户信息
	 * @param unum 用户编号(主键)
	 * @param uname 用户姓名
	 * @param uage 用户年纪
	 * @return 影响行数
	 */
    int insertUser(int unum, String uname, int uage);
    /**
     * 根据主键删除一条记录
     * @param unum 用户编号(主键)
     * @return 影响行数
     */
    int delUser(int unum);
    /**
     * 根据主键,更新用户姓名
     * @param unum 用户编号(主键)
     * @param uname 用户姓名
     * @return 影响行数
     */
    int updateUserName(int unum, String uname);
    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    List<User> selectAllUser();
    /**
     * 根据指定主键查询用户信息
     * @return 用户信息
     */
    User selectUser(int unum);
}
