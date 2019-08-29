package day14.javapro.beans.parse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import day14.javapro.beans.annotation.Autowired;
import day14.javapro.beans.annotation.Controller;
import day14.javapro.beans.annotation.Repository;
import day14.javapro.beans.annotation.Service;
import day14.javapro.beans.utils.CovertUtils;
import day14.javapro.beans.utils.FileUtils;

public class ComponentScan implements BeanFactory{
	//ȫ�ֹ�������
	private static final Map<String, Object> beans
		= new HashMap<String, Object>(); 
	
	//ɨ��Ŀ¼
	public List<String> scan(String baseDir, String dir) {
		//String baseDir = "D:\\java\\ws\\1907\\1907-javase\\bin\\";
		//String dir = "D:\\java\\ws\\1907\\1907-javase\\bin\\day14\\javapro\\beans\\";
		List<String> fileList = new ArrayList<String>();
		
		FileUtils.getFileName(dir, fileList);
		
		for(String filename : fileList) {
			System.out.println(filename);
		}
		return fileList;
	}
	
	//���ã��������󣬷���������
	public void create(List<String> filenameList, String baseDir) throws Exception {
		List<String> classnameList
			= CovertUtils.getClassName(baseDir, filenameList);
		
		//�������ϣ���������
		for(String classname : classnameList) {
			//���䴴������
			Class<?> clazz = Class.forName(classname);

			//����ע�����ж��Ƿ񴴽�����
			Controller ca = clazz.getAnnotation(Controller.class);
			Service sa = clazz.getAnnotation(Service.class);
			Repository ra = clazz.getAnnotation(Repository.class);
			
			String beanName = "";
			System.out.println("\n���������������󣬷�������");
			if(ca != null || sa != null || ra != null) {
				//��������
				Object obj = clazz.newInstance();
				//�������������
				beanName = CovertUtils.getBeanName(classname);
				
				beans.put(beanName, obj);
			}
			
			System.out.println(classname +" | " +beanName);
		}
		
		for(String key : beans.keySet()) {		//����key���ϣ����л�ȡԪ��
			System.out.println( beans.get(key) );
		}
	}

	//<T>����������T���Ƿ��ͣ�T������ֵ
	//Ҳ��Ϊ���ͷ���
	public <T> T getBean(String beanName) {
		return (T)beans.get(beanName);	//ǿת����
	}
	
	//ʵ��DI����ע�룬�Զ�װ��
	public void inject() throws Exception {
		//��������
		for(String beanName : beans.keySet()) {
			Object obj = getBean(beanName);
			//��ȡ�����ࣿ
			Class<?> clazz = obj.getClass();
			
			//�����������ԣ�������˽�����ԣ�
			Field[] fields = clazz.getDeclaredFields();
			for(Field f : fields) {
				//����Ȩ��
				f.setAccessible(true);
				
				//�ж��������Ƿ���@Autowiredע��
				Autowired aa = f.getAnnotation(Autowired.class);
				if(aa != null) {
					//��һ����������ǰ������������
					//�ڶ���������private˽������
					String subBeanName = f.getName();
					
					//method.invoke(obj);
					
					//����setע�뷽ʽ����ʵ��DI
					f.set(obj, getBean(subBeanName));
				}
			}
		}
	}
}
