package com.boco.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FileRead {

	public static void main(String[] args) {
		
	}
	
	public void readSubFileContent(String sourceFileName, Map<String, List> map) throws IOException {
		File file = new File(sourceFileName);
		String fileParent = file.getParent();
		File fileDir = new File(fileParent);
		if(fileDir.isDirectory()) {
			for(int i = 0; i < fileDir.listFiles().length; i++) {
				if(!fileDir.listFiles()[i].getPath().equals(sourceFileName)) {
					List<Integer> list = new ArrayList<Integer>();
					FileReader reader = new FileReader(fileDir.listFiles()[i]);
					BufferedReader br = new BufferedReader(reader);
					String lineNum = null;
					while((lineNum = br.readLine()) != null && !lineNum.equals("")) {
						list.add(Integer.parseInt(lineNum));
					}
					Collections.sort(list);
					Collections.reverse(list);
					map.put(String.valueOf(i), list);
				}
			}
		}
	}
	
	public void getMaxData(Map<String, List> map) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 1000; i++) {
			int temp = 0;
			String index = "";
			for(Entry<String, List> entry : map.entrySet()) {
				List<Integer> listOne = entry.getValue();
				if(listOne.size() > 0 && listOne.get(0) > temp) {
					temp = listOne.get(0);
					index = entry.getKey();
				}
			}
			map.get(index).remove(0);
			list.add(temp);
		}
		System.out.println(list.toString());
		System.out.println(list.size());
	}
}
