package day14.javapro.beans.utils;

import java.io.File;
import java.util.List;

public class FileUtils {

	//递归，指定开始目录，遍历自身目录和所有子目录
	//把所有文件名返回（包括路径）
	public static List<String> getFileName(String dir, List<String> fileList){
		//dir字符串变成File文件对象，利用File的api实现需求
		File file = new File(dir);
		//利用file方法listFiles()，返回这个路径下的所有目录+文件（只是当前目录，不包含子目录）
		File[] files = file.listFiles();
		for(File f : files) {
			if( f.isDirectory() ) {	//递归
				//必须有结束条件，for循环最终会结束，方法返回
				getFileName(f.getAbsolutePath(), fileList );
			}else {
				fileList.add(f.getAbsolutePath());
			}
		}
		return fileList;
	}
}





