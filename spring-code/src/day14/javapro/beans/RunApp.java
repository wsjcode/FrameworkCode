package day14.javapro.beans;

import java.util.List;

import day14.javapro.beans.controller.UserController;
import day14.javapro.beans.dao.UserDao;
import day14.javapro.beans.parse.BeanFactory;
import day14.javapro.beans.parse.ComponentScan;
import day14.javapro.beans.pojo.User;
import day14.javapro.beans.service.UserService;

public class RunApp {
	public static void main(String[] args) throws Exception {
	
		System.out.println("����·����");
		String baseDir = RunApp.class.getResource("/").getPath().substring(1);
		System.out.println(baseDir);
		
		/*
		 * ����ת��·��
		 * ����Ҫע��ֵ���ٽ�ֵ
		 */
		String packageName = RunApp.class.getPackage().getName();
		System.out.println(packageName);
		String scanDir = baseDir + packageName.replace(".", "/");
		System.out.println(scanDir);
		//String scanDir = "D:\\java\\ws\\1907\\1907-javase\\bin\\day14\\";
		//String baseDir = "D:\\java\\ws\\1907\\1907-javase\\bin\\";
		BeanFactory context = new ComponentScan();
		
		System.out.println("\n��һ������ɨ��");
		List<String> filenameList 
			= context.scan(baseDir, scanDir);
		
		System.out.println("\n�ڶ�����ת��������className");
		context.create(filenameList, baseDir);
	
		System.out.println("\n������������ע�룬�󶨶����ϵ");
		context.inject();
		
		//UserController uc = (UserController)context.getBean("userController");
		
		//ҵ��ĵ���
		System.out.println("\nҵ����ã�");
		
		UserDao ud = context.getBean("userDao");
		UserService us = context.getBean("userService");
		//us.setUserDao(ud);		//�����ϵҪ��
		
		UserController uc = context.getBean("userController");
		//�����ϵ����ϵ�󶨣�setע��
		//uc.setUserService(us);
		
		User user = uc.get(1);
		System.out.println(user);
	}
}
