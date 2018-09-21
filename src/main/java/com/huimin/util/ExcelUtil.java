package com.huimin.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtil {

	private static final LogUtil logger = LogUtil.logger(ExcelUtil.class);

	private static NumberFormat numberFormat = NumberFormat.getInstance();

	static {
		numberFormat.setGroupingUsed(false);
	}

	/**
	 * 导出Excel
	 * 
	 * @param sheetName
	 *            sheet名称
	 * @param title
	 *            标题
	 * @param values
	 *            内容
	 * @param wb
	 *            HSSFWorkbook对象
	 * @return
	 */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, List<List<Object>> values,
			HSSFWorkbook wb) {

		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		// 创建一个居中格式
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setWrapText(true);
		// 声明列对象
		HSSFCell cell = null;

		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}

		// 创建内容
		fillExcel(sheet, style, values);
		return wb;
	}

	/**
	 * 导出Excel 大量数据
	 * 
	 * @param sheetName
	 *            sheet名称
	 * @param title
	 *            标题
	 * @param values
	 *            内容
	 * @param wb
	 *            HSSFWorkbook对象
	 * @return
	 */
	public static XSSFWorkbook getXSSFWorkbook(String sheetName, String[] title, List<List<Object>> values,
			XSSFWorkbook wb) {

		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new XSSFWorkbook();
		}

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		XSSFRow row = sheet.createRow(0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		// 创建一个居中格式
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);
		style.setWrapText(true);
		// 声明列对象
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		fillExcel(sheet, style, values);
		return wb;
	}
	public static void getXSSFWorkbook(String sheetName, String[] title, List<List<Object>> values,
			XSSFWorkbook wb, String passWord, OutputStream outputStream) {
		 getXSSFWorkbook(getXSSFWorkbook(sheetName, title, values, wb), passWord, outputStream);
	}
	/**
	 * 为Excel设置密码 并写入输出流
	 * @param wb
	 * @param password
	 * @param outputStream
	 */
	public static void getXSSFWorkbook(XSSFWorkbook wb, String password, OutputStream outputStream) {
		// 把工作薄输出到字节里面
		try {
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			// POI对Excel文件加密
			wb.write(bout);
			bout.flush();
			ByteArrayInputStream Workbookinput = new ByteArrayInputStream(bout.toByteArray());
			// 创建POIFS文件系统 加密文件
			POIFSFileSystem fs = new POIFSFileSystem();
			// EncryptionInfo info = new EncryptionInfo(fs, EncryptionMode.agile);
			EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
			Encryptor enc = info.getEncryptor();
			enc.confirmPassword(password);
			// 然后把字节输入到输入流，然后输入到OPC包里面
			OPCPackage opc = OPCPackage.open(Workbookinput);
			OutputStream os = enc.getDataStream(fs);
			opc.save(os);
			opc.close();
			fs.writeFilesystem(outputStream);
//			String fileName = UUID.randomUUID().toString() + ".xlsx";
//			File file = new File(fileName);
//			FileOutputStream fileOutputStream = new FileOutputStream(file);
//		    fs.writeFilesystem(fileOutputStream);
//		    FileInputStream fileInputStream = new FileInputStream(file);
//		    POIFSFileSystem pfs = new POIFSFileSystem(fileInputStream);
//		    fileInputStream.close();
//		    fileOutputStream.close();
//			EncryptionInfo encInfo = new EncryptionInfo(pfs);
//			Decryptor decryptor = Decryptor.getInstance(encInfo);
//			decryptor.verifyPassword(password);
//			 new XSSFWorkbook(decryptor.getDataStream(pfs));

		} catch (Exception e) {
			logger.error("加密Excel失败", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 导入Excel 将行和列读为二位数组
	 * 
	 * @param inputStream
	 * @return
	 */
	public static List<List<String>> readExcel(File file) {
		if (file == null || !file.isFile()) {
			return null;
		}
		try {
			return readExcel(new FileInputStream(file), file.getName());
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException("read  Excel error", e);
		}
	}

	public static List<List<String>> readExcel(MultipartFile file) {
		if (file == null || file.isEmpty()) {
			return null;
		}
		try {
			return readExcel(file.getInputStream(), file.getOriginalFilename());
		} catch (Exception e) {
			logger.error(e);
			throw new RuntimeException("read  Excel error", e);
		}
	}

	public static List<List<String>> readExcel(InputStream stream, String fileName) throws Exception {
		List<List<String>> lists = new ArrayList<List<String>>();
		if (stream == null || StringUtils.isEmpty(fileName)) {
			return lists;
		}
		String type = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		try (Workbook workbook = "xls".equals(type) ? new HSSFWorkbook(stream) : new XSSFWorkbook(stream);) {
			Sheet sheet = workbook.getSheetAt(0);
			List<String> list = null;
			Row row = null;
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				list = new ArrayList<>();
				row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					list.add(getCellValue(row.getCell(j)));
				}
				lists.add(list);
			}
			return lists;
		}
	}

	private static String getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		switch (cellType) {
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue() + "";
		case BLANK:
			return "";
		case ERROR:
			return "非法字符";
		case FORMULA:// 公式
			return cell.getCellFormula();
		case NUMERIC:// 公式
			// 如果为时间格式的内容
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				return DateUtil.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
			} else {
				return numberFormat.format(cell.getNumericCellValue());
			}
		default:
			return "未知类型";
		}
	}

	private static void fillExcel(Sheet sheet, CellStyle style, List<List<Object>> values) {
		Row row;
		Cell cell;
		for (int i = 0; i < values.size(); i++) {
			row = sheet.createRow(i + 1);
			List<Object> rows = values.get(i);
			for (int j = 0; j < rows.size(); j++) {
				// 将内容按顺序赋给对应的列对象
				cell = row.createCell(j);
				cell.setCellStyle(style);
				Object obj = rows.get(j);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof RichTextString) {
					cell.setCellValue((RichTextString) obj);
				} else {
					cell.setCellValue(obj == null ? null : obj.toString());
				}
				if (obj != null) {
					// 自适应列宽
					int columnWidth = sheet.getColumnWidth(j);
					String value = obj.toString();
					if (!value.contains("\r\n")) {
						int length = value.getBytes().length * 256;
						if (length > columnWidth) {
							sheet.setColumnWidth(j, length);
						}
					}
				}
				}
			}
		}

	public static void main(String[] args) {
		File file2 = new File("C:\\Users\\ThinkPad\\Desktop\\文档\\异常考勤申请-智盛_1.xls");
		List<List<String>> excel = ExcelUtil.readExcel(file2);
		System.out.println(excel);
	}
}
