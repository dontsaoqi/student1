package com.hrious.serviceImpl;

import java.util.List;
import java.util.Scanner;

import com.hrious.dao.UserDao;
import com.hrious.daoImpl.UserDaoImpl;
import com.hrious.pojo.User;
import com.hrious.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud = new UserDaoImpl();

	@Override
	public void insertUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户编号(unum):");
		int unum = sc.nextInt();
		System.out.println("请输入用户姓名(uname):");
		String uname = sc.next();
		System.out.println("请输入用户年龄(uage):");
		int uage = sc.nextInt();
		
		int i = ud.insertUser(unum, uname, uage);
		
		if (i > 0) {
			System.out.println("插入成功!");
		} else {
			System.out.println("插入失败!");
		}
		
	}

	@Override
	public void delUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户编号(unum):");
		int unum = sc.nextInt();
		
		int i = ud.delUser(unum);
		
		if (i > 0) {
			System.out.println("删除成功!");
		} else {
			System.out.println("删除失败!");
		}
		
	}

	@Override
	public void updateUserName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户编号(unum):");
		int unum = sc.nextInt();
		System.out.println("请输入用户姓名(uname):");
		String uname = sc.next();
		
		int i = ud.updateUserName(unum, uname);
		
		if (i > 0) {
			System.out.println("更新成功!");
		} else {
			System.out.println("更新失败!");
		}
		
	}

	@Override
	public void selectUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户编号(unum):");
		int unum = sc.nextInt();
		
		User u = ud.selectUser(unum);
		
		if (u != null) {
			System.out.println("用户编号(unum)  用户姓名(uname)  用户年纪(uage)");
			System.out.println(u.getUnum() + "\t\t" + u.getUname() + "\t\t" + u.getUage());
		} else {
			System.out.println("数据为空!");
		}
		
	}

	@Override
	public void selectAllUser() {
		Scanner sc = new Scanner(System.in);
		
		List<User> list = ud.selectAllUser();
		int len = list.size();
		
		if (len > 0) {
			System.out.println("用户编号(unum)  用户姓名(uname)  用户年纪(uage)");
			for (int i = 0; i < len; i++) {
				User u = list.get(i);
				System.out.println(u.getUnum() + "\t\t" + u.getUname() + "\t\t" + u.getUage());
			}
		} else {
			System.out.println("数据为空!");
		}
		
	}

}
