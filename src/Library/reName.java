package Library;

import java.io.*;

public class reName {
	
	static final String DEFAULT_IMAGE_PATH =  "./images";
	
	public void rename(String path, String oldName, String newName)throws Exception{
		String srcPath = path + oldName;
		FileInputStream fi = new FileInputStream(srcPath);
		BufferedInputStream in = new BufferedInputStream(fi);
		newName = oldName.replaceAll(oldName, newName) + ".jpg";
		File destDir = new File(DEFAULT_IMAGE_PATH);
		if(!destDir.exists()){
			destDir.mkdir();
		}
		String destPath = destDir.toString() + "\\" + newName;
		FileOutputStream fo = new FileOutputStream(destPath);
		BufferedOutputStream out = new BufferedOutputStream(fo);
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		while(len != -1){
			out.write(buf, 0, len);
			len = in.read(buf);
		}
		out.close();
		fo.close();
		in.close();
		fi.close();
	}
}

