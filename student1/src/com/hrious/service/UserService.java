package com.hrious.service;

public interface UserService {
	/**
	 * 插入用户信息
	 */
	void insertUser();
	/**
	 * 删除用户信息
	 */
	void delUser();
	/**
	 * 根据主键,更新用户姓名
	 */
	void updateUserName();
	/**
	 * 查询一条用户信息
	 */
	void selectUser();
	/**
	 * 查询所有用户信息
	 */
	void selectAllUser();
}
