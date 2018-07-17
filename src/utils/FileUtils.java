package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 
 * @author HW
 * 
 */
public class FileUtils {
	private static String filenametemp;

	/**
	 * 
	 * @param filename(文件名称)
	 * @param fileContent(文件内容)
	 */
	public static boolean createFile(String filename, String fileContent) {
		String filenametemp = filename + ".html";
		Boolean bool = false;
		File file = new File(filenametemp);
		try {
			
			if (!file.exists()) {
				file.createNewFile();
				bool = true;
				System.out.println("成功创建文件："+filenametemp);
				writeFileContent(filenametemp, fileContent);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * 
	 * @param path(生成的文件的存放路径)
	 * @param newContent(需要写入的内容)
	 * @return 创建成功则返回true失败则返回false
	 */
	public static boolean writeFileContent(String path, String newContent) {
		Boolean bool = false;

		String temp = "";
		//
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		PrintWriter pw = null;
		filenametemp = path;
		try {
			File file = new File(filenametemp);
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; (temp = br.readLine()) != null; i++) {
				stringBuffer.append(temp);
				stringBuffer.append(System.getProperty("line.separator"));
			}
			stringBuffer.append(newContent);
			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(stringBuffer.toString().toCharArray());
			pw.flush();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			try {
				if (fos != null) {
					fos.close();
				}
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return bool;
	}
	
	/**
	 * 
	 * @param filePath(需要删除的文件路径)
	 * @return 文件删除或文件不存在返回true
	 */
	public static boolean delFile(String filePath) {
		Boolean bool = false;
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
			bool = true;
		}
		if (!file.exists()) {
			bool = true;
		}
		return bool;
	}
}
