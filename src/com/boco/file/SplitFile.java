package com.boco.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SplitFile {
	
	public void splitFile(String fileName) throws IOException {
		File sourceFile = new File(fileName);
		int subFileNum = 100;//子文件的个数
		long sourceFileLength = sourceFile.length();//原文件大小
		long subFileLength = sourceFileLength / subFileNum;//子文件大小
		byte [] b = new byte[1024];
		RandomAccessFile readSourcefile = new RandomAccessFile(sourceFile, "r");
		for(int i = 0; i < subFileNum; i++) {
			String subFileName = sourceFile.getParentFile() + "\\" + (sourceFile.getName()).split("\\.")[0] + "_" + i + ".txt";
			File subFile = new File(subFileName);
			subFile.createNewFile();
			int length = -1;
			RandomAccessFile writeSubFile = new RandomAccessFile(subFile, "rw");
			while((length = readSourcefile.read(b)) != -1) {
				writeSubFile.write(b, 0, length);
				if(writeSubFile.length() > subFileLength) {
					break;
				}
			}
			writeSubFile.close();
		}
		readSourcefile.close();
	}

}
