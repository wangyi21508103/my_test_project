package com.boco.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boco.file.FileRead;
import com.boco.file.FileWriteUtil;
import com.boco.file.SplitFile;

public class ApplicationMain {
	private static final String sourceFileName = "D:\\testfile\\input.txt";
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < 10000; i++) {
			FileWriteUtil fileWriteUtil = FileWriteUtil.getInstance();
			int randomNum = fileWriteUtil.getRandomNum();
			fileWriteUtil.writeRandomNumToFile(randomNum, sourceFileName);
		}
		SplitFile splitFile = new SplitFile();
		splitFile.splitFile(sourceFileName);
		
		Map<String, List> map = new HashMap<String, List>();
		FileRead fileRead = new FileRead();
		fileRead.readSubFileContent(sourceFileName, map);
		
		fileRead.getMaxData(map);
	}

}
