package com.hrious.test;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.hrious.service.UserService;
import com.hrious.serviceImpl.UserServiceImpl;

public class Test {
	private static Logger logger = Logger.getLogger(Test.class);

	public static void main(String[] args) {
		logger.debug("��������");
		Scanner sc = new Scanner(System.in);
		UserService us = new UserServiceImpl();
		do {
			System.out.println("*****��ӭʹ���û���Ϣ����ϵͳ*****");
			System.out.println("*********�����û���Ϣ(1)*********");
			System.out.println("*********ɾ���û���Ϣ(2)*********");
			System.out.println("*********�޸��û�����(3)*********");
			System.out.println("*********��ѯһ���û���Ϣ(4)******");
			System.out.println("*********��ѯ�����û���Ϣ(5)******");
			System.out.println("*************�˳�(6)*************");
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
					logger.debug("�رճ���");
					System.out.println("��ӭʹ��");
					return;
				}
			default:
				System.out.println("��������ȷ�Ĳ������!");
				break;
			}
		} while (true);
	}

}
