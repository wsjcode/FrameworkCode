package day14.javapro.beans.utils;

import java.util.List;

public class CovertUtils {
	//ת���ļ�·����className
	//��ԭ�м��ϵ�ÿ��Ԫ�ر��className��ʽ
	public static List<String> getClassName(String baseDir, List<String> fileList){
		for(int i=0; i< fileList.size(); i++) {
			String filename = fileList.get(i);
			
			filename = filename.replace("\\", "/");
			baseDir = baseDir.replace("\\", "/");
			
			//�滻��׼·��
			//�ѿ�ͷ�滻��
			filename = filename.replace(baseDir, "");
			int pos = filename.lastIndexOf(".");
			//��.classȥ��
			filename = filename.substring(0, pos);
			//��·����/�滻��·���ָ���.
			filename = filename.replace("/", ".");
			
			//��ת����classname���ûض�Ӧλ�ã�λ�����ݾ͸���
			fileList.set(i, filename);
		}
		return fileList;	//������һ��fileList
	}
	
	//��classNameת��beanName
	public static String getBeanName(String className) {
		//1.ת��ȫСд
		int pos = className.lastIndexOf(".") +1;
		className = className.substring(pos);	//UserController
		
		//2.��ȡ��һ�ַ�
		//3.�ӵ�һ��֮��ش���ƴ��
		String beanName = className.toLowerCase().charAt(0) + className.substring(1);
		return beanName;
	}
}




