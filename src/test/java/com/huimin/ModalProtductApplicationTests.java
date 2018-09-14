package com.huimin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.plugins.Page;
import com.huimin.entity.security.User;
import com.huimin.mail.EmailService;
import com.huimin.service.UserService;
import com.huimin.util.ExcelUtil;
import com.huimin.util.HttpClientUtils;

//@RunWith(SpringRunner.class)
//@SpringBootTest
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
		//hssfWorkbook.writeProtectWorkbook("123456", "234");
		hssfWorkbook.getSheetAt(0).protectSheet("123456");
		Map<String, Workbook> attachments = new HashMap<>();
		attachments.put("测试发送邮件.xlsx", hssfWorkbook);
		
		emailService.sendTemplateMail("zhuliang2@huimin100.cn", "测试发送邮件", "测试发送邮件", attachments );
	}
	@Test
	public void test04() throws Exception {
		String[] title = {"用户id", "用户名称"};
		//POI对Excel文件加密	
				POIFSFileSystem fs = new POIFSFileSystem();
		        EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
		        Encryptor enc = info.getEncryptor();
		        enc.confirmPassword("123456");
		        String filePath = "C:\\Users\\ThinkPad\\Desktop\\考勤审批记录模板2018_8_31.xls";
				OPCPackage opc = OPCPackage.open(new File(filePath), PackageAccess.READ_WRITE);
		        OutputStream os = enc.getDataStream(fs);
		        opc.save(os);
		        opc.close();
		        
		        FileOutputStream fos = new FileOutputStream(filePath);
		        fs.writeFilesystem(fos);
		        fos.close();
		        fs.close();

//		Map<String, Workbook> attachments = new HashMap<>();
//		attachments.put("测试发送邮件.xlsx", hssfWorkbook);
//		
//		emailService.sendTemplateMail("zhuliang2@huimin100.cn", "测试发送邮件", "测试发送邮件", attachments );
	}

	
}
