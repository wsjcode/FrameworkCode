package day14.javapro.beans.utils;

import java.io.File;
import java.util.List;

public class FileUtils {

	//�ݹ飬ָ����ʼĿ¼����������Ŀ¼��������Ŀ¼
	//�������ļ������أ�����·����
	public static List<String> getFileName(String dir, List<String> fileList){
		//dir�ַ������File�ļ���������File��apiʵ������
		File file = new File(dir);
		//����file����listFiles()���������·���µ�����Ŀ¼+�ļ���ֻ�ǵ�ǰĿ¼����������Ŀ¼��
		File[] files = file.listFiles();
		for(File f : files) {
			if( f.isDirectory() ) {	//�ݹ�
				//�����н���������forѭ�����ջ��������������
				getFileName(f.getAbsolutePath(), fileList );
			}else {
				fileList.add(f.getAbsolutePath());
			}
		}
		return fileList;
	}
}





