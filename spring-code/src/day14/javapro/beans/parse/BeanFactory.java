package day14.javapro.beans.parse;

import java.util.List;

public interface BeanFactory {
	public List<String> scan(String baseDir, String dir);
	public void create(List<String> filenameList, String baseDir)
			throws Exception;
	
	//public Object getBean(String beanName);
	//��ô�÷��͸�������ķ��������ͱ��뷺�Ͳ��������Object
	public <T> T getBean(String beanName);
	
	//����ע��
	public void inject() throws Exception;
	
	
	
	
	
	
}
