package com.hrious.test;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.hrious.service.UserService;
import com.hrious.serviceImpl.UserServiceImpl;

public class Test {
	private static Logger logger = Logger.getLogger(Test.class);

	public static void main(String[] args) {
		logger.debug("程序启动");
		Scanner sc = new Scanner(System.in);
		UserService us = new UserServiceImpl();
		do {
			System.out.println("*****欢迎使用用户信息管理系统*****");
			System.out.println("*********插入用户信息(1)*********");
			System.out.println("*********删除用户信息(2)*********");
			System.out.println("*********修改用户姓名(3)*********");
			System.out.println("*********查询一条用户信息(4)******");
			System.out.println("*********查询所有用户信息(5)******");
			System.out.println("*************退出(6)*************");
			System.out.println("*********************************");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				us.insertUser();
				break;
			case 2:
				us.delUser();
				break;
			case 3:
				us.updateUserName();
				break;
			case 4:
				us.selectUser();
				break;
			case 5:
				us.selectAllUser();
				break;
			case 6:
				if (sc != null) {
					sc.close();
					logger.debug("关闭程序");
					System.out.println("欢迎使用");
					return;
				}
			default:
				System.out.println("请输入正确的操作编号!");
				break;
			}
		} while (true);
	}

}
