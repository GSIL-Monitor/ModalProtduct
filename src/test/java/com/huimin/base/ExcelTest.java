package com.huimin.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.huimin.util.ExcelUtil;

public class ExcelTest {

	
	@Test
	public  void test03() throws Exception {
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File("C:\\Users\\ThinkPad\\Desktop\\文档\\异常考勤申请-智盛_1.xls")));
		XSSFWorkbook xssfWorkbook = ExcelUtil.hssfWorkbook2XSSFWorkbook(hssfWorkbook);
		OutputStream outputStream = new FileOutputStream("C:\\Users\\ThinkPad\\Desktop\\测试Excel转换.xlsx");
		xssfWorkbook.write(outputStream);
		outputStream.close();
	}
	@Test
	public  void test02() throws Exception {
		List<List<Object>> values = new ArrayList<>();
		List<List<String>> readExcel = ExcelUtil.readExcel(new File("C:\\Users\\ThinkPad\\Desktop\\文档\\异常考勤申请-智盛_1.xls"));
		List<String> title = readExcel.remove(0);
		for (List<String> list : readExcel) {
			values.add(new ArrayList<>(list));
		}
		OutputStream outputStream = new FileOutputStream("C:\\Users\\ThinkPad\\Desktop\\测试加密.xlsx");
		String[] titles = title.toArray(new String[title.size()]);
		ExcelUtil.getXSSFWorkbook("测试架米", titles, values, null, "123456", outputStream);
	}
	@Test
	public void test01() throws Exception {
		String[] title = { "ID", "姓名", "性别", "年龄" };
		List<List<Object>> values = new ArrayList<List<Object>>();
		List<Object> value = new ArrayList<>();
		value.add(1);
		value.add("刘备");
		value.add("男");
		value.add(35);
		values.add(value);
		String passWord = "123456";
		FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ThinkPad\\Desktop\\人员信息.xlsx");
		ExcelUtil.getXSSFWorkbook("人员信息", title, values, null, passWord, outputStream);
		outputStream.close();
		
		List<List<String>> readExcel = ExcelUtil.readExcel(new FileInputStream("C:\\Users\\ThinkPad\\Desktop\\人员信息.xlsx"), "人员信息.xlsx", passWord);
		System.out.println(readExcel);
	}
}
