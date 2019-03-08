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
		System.out.println("�������û����(unum):");
		int unum = sc.nextInt();
		System.out.println("�������û�����(uname):");
		String uname = sc.next();
		System.out.println("�������û�����(uage):");
		int uage = sc.nextInt();
		
		int i = ud.insertUser(unum, uname, uage);
		
		if (i > 0) {
			System.out.println("����ɹ�!");
		} else {
			System.out.println("����ʧ��!");
		}
		
	}

	@Override
	public void delUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û����(unum):");
		int unum = sc.nextInt();
		
		int i = ud.delUser(unum);
		
		if (i > 0) {
			System.out.println("ɾ���ɹ�!");
		} else {
			System.out.println("ɾ��ʧ��!");
		}
		
	}

	@Override
	public void updateUserName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û����(unum):");
		int unum = sc.nextInt();
		System.out.println("�������û�����(uname):");
		String uname = sc.next();
		
		int i = ud.updateUserName(unum, uname);
		
		if (i > 0) {
			System.out.println("���³ɹ�!");
		} else {
			System.out.println("����ʧ��!");
		}
		
	}

	@Override
	public void selectUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û����(unum):");
		int unum = sc.nextInt();
		
		User u = ud.selectUser(unum);
		
		if (u != null) {
			System.out.println("�û����(unum)  �û�����(uname)  �û����(uage)");
			System.out.println(u.getUnum() + "\t\t" + u.getUname() + "\t\t" + u.getUage());
		} else {
			System.out.println("����Ϊ��!");
		}
		
	}

	@Override
	public void selectAllUser() {
		Scanner sc = new Scanner(System.in);
		
		List<User> list = ud.selectAllUser();
		int len = list.size();
		
		if (len > 0) {
			System.out.println("�û����(unum)  �û�����(uname)  �û����(uage)");
			for (int i = 0; i < len; i++) {
				User u = list.get(i);
				System.out.println(u.getUnum() + "\t\t" + u.getUname() + "\t\t" + u.getUage());
			}
		} else {
			System.out.println("����Ϊ��!");
		}
		
	}

}
