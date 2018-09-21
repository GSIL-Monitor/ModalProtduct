package com.huimin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.huimin.entity.security.User;
import com.huimin.mail.EmailService;
import com.huimin.service.UserService;
import com.huimin.util.ExcelUtil;
import com.huimin.util.HttpClientUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModalProtductApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private  EmailService emailService;
	@Test
	public void contextLoads() {
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("id", 10);
	   map.put("name", "周瑜");
	   String json = HttpClientUtils.doPostJson("http://127.0.0.1:8081/test", map);
	   System.out.println(json);
	}
	
	@Test
	public void test02() {
		Page<User> page = new Page<>(1, 10);
		page = userService.selectPage(page);
		System.out.println(page);
	}
	@Test
	public void test03() {
		String[] title = {"用户id", "用户名称"};
		List<List<Object>> values = new ArrayList<List<Object>>();
		List<Object> value = new ArrayList<>();
		value.add(123);
		value.add("尽职尽责");
		values.add(value);
		//XSSFWorkbook xssfWorkbook = ExcelUtil.getXSSFWorkbook("测试", title , values , null);
		HSSFWorkbook hssfWorkbook = ExcelUtil.getHSSFWorkbook("ccc", title, values, null);
		Map<String, Workbook> attachments = new HashMap<>();
		attachments.put("测试发送邮件.xls", hssfWorkbook);
		emailService.sendTemplateMail("zhuliang2@huimin100.cn", "测试发送邮件", "测试发送邮件", attachments );
	}

	@Test
	public void test04() throws Exception {
		String[] title = {"用户id", "用户名称"};
		//POI对Excel文件加密	
		String path = "C:\\Users\\ThinkPad\\Desktop\\EHR组(1).xlsx";
		POIFSFileSystem fs = new POIFSFileSystem();
		EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
		Encryptor enc = info.getEncryptor();
		enc.confirmPassword("123456");
//		OPCPackage opc = OPCPackage.open(new File(path), PackageAccess.READ_WRITE);
//		OutputStream os = enc.getDataStream(fs);
//		opc.save(os);
//		opc.close();
		FileOutputStream fos = new FileOutputStream(path);
		fs.writeFilesystem(fos);
		fos.close();
		
//		Map<String, Workbook> attachments = new HashMap<>();
//		attachments.put("测试发送邮件.xlsx", hssfWorkbook);
//		
//		emailService.sendTemplateMail("zhuliang2@huimin100.cn", "测试发送邮件", "测试发送邮件", attachments );
	}
	@Test
	public void test05() throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet1 =wb.createSheet("sheet1");
        Row row1=sheet1.createRow(0);
        row1.createCell(0).setCellValue("aaaaa");
        row1.createCell(1).setCellValue("bbbbb");
        row1.createCell(2).setCellValue("ccccc");
        row1.createCell(3).setCellValue("ddddd");
        //把工作薄输出到字节里面
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        wb.write(bout);
        bout.flush();
        ByteArrayInputStream Workbookinput = new ByteArrayInputStream(bout.toByteArray());
        //创建POIFS文件系统  加密文件
        POIFSFileSystem fs = new POIFSFileSystem();
  //EncryptionInfo info = new EncryptionInfo(fs, EncryptionMode.agile);
        EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
  Encryptor enc = info.getEncryptor();
  enc.confirmPassword("123456");
 //然后把字节输入到输入流，然后输入到OPC包里面
  OPCPackage opc = OPCPackage.open(Workbookinput);
  OutputStream os = enc.getDataStream(fs);
  opc.save(os);
  opc.close();

  FileOutputStream fos = new FileOutputStream("C:\\Users\\ThinkPad\\Desktop\\excel1.xlsx");
  fs.writeFilesystem(fos);
  fos.close();
	}
	
}
