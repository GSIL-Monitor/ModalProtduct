package com.huimin.base;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.huimin.util.ExcelUtil;

public class ExcelTest {

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
	}
}
