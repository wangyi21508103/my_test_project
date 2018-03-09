package com.boco.file;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileWriteUtil {
	
	private static FileWriteUtil fileWriteUtil;
	
	private FileWriteUtil() {
		
	}
	
	public static FileWriteUtil getInstance() {
		if(null == fileWriteUtil) {
			fileWriteUtil = new FileWriteUtil();
		}
		return fileWriteUtil;
	}

	/**
	 * Generate a random number from 0 to 10000
	 */
	public int getRandomNum() {
		Random random = new Random();
		int randomNum = random.nextInt(10000);
		return randomNum;
	}
	
	/**
	 * Write the random number to file
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void writeRandomNumToFile(int randomNum, String fileName) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName, true);
			fileWriter.write(Integer.toString(randomNum) + "\n");
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		}
	}

}
