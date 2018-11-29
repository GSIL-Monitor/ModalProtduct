package com.huimin.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.huimin.util.ExcelUtil;

public class Java8Test {

	
	@Test
	public void test01() throws Exception {
		String[] filepaths = {"C:\\Users\\ThinkPad\\Desktop\\localhost_access_log.2018-10-28.txt","C:\\Users\\ThinkPad\\Desktop\\localhost_access_log.2018-10-27.txt",
				"C:\\Users\\ThinkPad\\Desktop\\localhost_access_log.2018-10-26.txt","C:\\Users\\ThinkPad\\Desktop\\localhost_access_log.2018-10-25.txt",
				"C:\\Users\\ThinkPad\\Desktop\\localhost_access_log.2018-10-24.txt","C:\\Users\\ThinkPad\\Desktop\\localhost_access_log.2018-10-29.txt"};
		Map<String, Integer> map = new HashMap<>();
		BufferedReader bufferedReader = null;
		for (String filepath : filepaths) {
			
			// FileInputStream fileInputStream = new FileInputStream(filepath);
			bufferedReader = new BufferedReader(new FileReader(new File(filepath)));
			String readLine = null;
			while ((readLine = bufferedReader.readLine()) != null) {
				if (readLine.contains("POST")) {
					String url = readLine.substring(readLine.indexOf("POST") + 4, readLine.indexOf("HTTP")).trim();
					Integer count = map.get(url);
					if (count == null) {
						map.put(url, 1);
					}else {
						map.put(url, count + 1);
					}
				}
			}
		}
	  String[] title = {"接口名称", "访问次数"};
       List<List<Object>> values = new ArrayList<List<Object>>();
				map.forEach((key, value) -> {
			List<Object> list = new ArrayList<>();
			list.add(key);
			list.add(value);
			values.add(list);
		});
	    
		XSSFWorkbook xssfWorkbook = ExcelUtil.getXSSFWorkbook("org接口统计", title, values, null);
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ThinkPad\\Desktop\\org接口统计.xlsx");
		xssfWorkbook.write(fileOutputStream);
	    fileOutputStream.close();
	    bufferedReader.close();
	}
}
