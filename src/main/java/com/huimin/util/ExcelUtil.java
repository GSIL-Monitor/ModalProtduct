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
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.Decryptor;
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
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
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
	 *            XSSFWorkbook对象
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

	/**
	 * 加密导出Excel
	 * @param sheetName
	 * @param title
	 * @param values
	 * @param wb
	 * @param passWord
	 * @param outputStream
	 */
	public static void getXSSFWorkbook(String sheetName, String[] title, List<List<Object>> values, XSSFWorkbook wb,
			String passWord, OutputStream outputStream) {
		getXSSFWorkbook(getXSSFWorkbook(sheetName, title, values, wb), passWord, outputStream);
	}

	/**
	 * 为Excel设置密码 并写入输出流
	 * 
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

	public static List<List<String>> readExcel(InputStream stream, String fileName, String password) {
		List<List<String>> lists = new ArrayList<List<String>>();
		if (stream == null || StringUtils.isEmpty(fileName)) {
			return lists;
		}
		String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);

		Workbook workbook;
		try {
			if (prefix.toUpperCase().equals("XLS")) {
				org.apache.poi.hssf.record.crypto.Biff8EncryptionKey.setCurrentUserPassword(password);
				workbook = WorkbookFactory.create(stream);
			} else {
				POIFSFileSystem pfs = new POIFSFileSystem(stream);
				EncryptionInfo encInfo = new EncryptionInfo(pfs);
				Decryptor decryptor = Decryptor.getInstance(encInfo);
				decryptor.verifyPassword(password);
				workbook = new XSSFWorkbook(decryptor.getDataStream(pfs));
			}
			return readExcel(workbook);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static List<List<String>> readExcel(InputStream stream, String fileName) throws Exception {
		List<List<String>> lists = new ArrayList<List<String>>();
		if (stream == null || StringUtils.isEmpty(fileName)) {
			return lists;
		}
		String type = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toLowerCase();
		try (Workbook workbook = "xls".equals(type) ? new HSSFWorkbook(stream) : new XSSFWorkbook(stream);) {
			return readExcel(workbook);
		}
	}

	public static List<List<String>> readExcel(Workbook workbook) throws Exception {
		List<List<String>> lists = new ArrayList<List<String>>();
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

	public static XSSFWorkbook hssfWorkbook2XSSFWorkbook(HSSFWorkbook hssfWorkbook) {
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		if (hssfWorkbook == null) {
			return xssfWorkbook;
		}
		XSSFCellStyle xssfCellStyle = xssfWorkbook.createCellStyle();
		XSSFFont xssfFont = xssfWorkbook.createFont();
		Iterator<Sheet> sheetIterator = hssfWorkbook.sheetIterator();
		while (sheetIterator.hasNext()) {
			HSSFSheet sheet = (HSSFSheet) sheetIterator.next();
			XSSFSheet xssfSheet = xssfWorkbook.createSheet(sheet.getSheetName());
			xssfSheet.setActiveCell(sheet.getActiveCell());
			xssfSheet.setAutobreaks(sheet.getAutobreaks());
			xssfSheet.setDefaultColumnWidth(sheet.getDefaultColumnWidth());
			xssfSheet.setDefaultRowHeight(sheet.getDefaultRowHeight());
			xssfSheet.setDefaultRowHeightInPoints(sheet.getDefaultRowHeightInPoints());
			xssfSheet.setDisplayGuts(sheet.getDisplayGuts());
			xssfSheet.setFitToPage(sheet.getFitToPage());
			xssfSheet.setForceFormulaRecalculation(sheet.getForceFormulaRecalculation());
			xssfSheet.setHorizontallyCenter(sheet.getHorizontallyCenter());
			xssfSheet.setRepeatingColumns(sheet.getRepeatingColumns());
			xssfSheet.setRepeatingRows(sheet.getRepeatingRows());
			xssfSheet.setRowSumsBelow(sheet.getRowSumsBelow());
			xssfSheet.setRowSumsRight(sheet.getRowSumsRight());
			xssfSheet.setVerticallyCenter(sheet.getVerticallyCenter());
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				XSSFRow xssfRow = xssfSheet.createRow(i);
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					HSSFCell cell = (HSSFCell) row.getCell(j);
					XSSFCell xssfCell = xssfRow.createCell(j);
					xssfCell.setCellComment(cell.getCellComment());
					HSSFCellStyle cellStyle = cell.getCellStyle();
				//	xssfCellStyle.cloneStyleFrom(cellStyle);
					xssfCellStyle.setAlignment(cellStyle.getAlignmentEnum());
					xssfCellStyle.setBorderBottom(cellStyle.getBorderBottomEnum());
					xssfCellStyle.setBorderLeft(cellStyle.getBorderLeftEnum());
					xssfCellStyle.setBorderRight(cellStyle.getBorderRightEnum());
					xssfCellStyle.setBorderTop(cellStyle.getBorderTopEnum());
					xssfCellStyle.setBottomBorderColor(cellStyle.getBottomBorderColor());
					xssfCellStyle.setDataFormat(cellStyle.getDataFormat());
					xssfCellStyle.setFillBackgroundColor(cellStyle.getFillBackgroundColor());
					xssfCellStyle.setFillPattern(cellStyle.getFillPatternEnum());
					HSSFFont font = cellStyle.getFont(hssfWorkbook);
					xssfFont.setBold(font.getBold());
					xssfFont.setCharSet(font.getCharSet());
					xssfFont.setColor(font.getColor());
					xssfFont.setFontHeight(font.getFontHeight());
					xssfFont.setFontHeightInPoints(font.getFontHeightInPoints());
					xssfFont.setFontName(font.getFontName());
					xssfFont.setItalic(font.getItalic());
					xssfFont.setStrikeout(font.getStrikeout());
					xssfFont.setTypeOffset(font.getTypeOffset());
					xssfFont.setUnderline(font.getUnderline());
					xssfCellStyle.setFont(xssfFont);
					xssfCellStyle.setHidden(cellStyle.getHidden());
					xssfCellStyle.setIndention(cellStyle.getIndention());
					xssfCellStyle.setLeftBorderColor(cellStyle.getLeftBorderColor());
					xssfCellStyle.setLocked(cellStyle.getLocked());
					xssfCellStyle.setQuotePrefixed(cellStyle.getQuotePrefixed());
					xssfCellStyle.setRightBorderColor(cellStyle.getRightBorderColor());
					xssfCellStyle.setRotation(cellStyle.getRotation());
					xssfCellStyle.setShrinkToFit(cellStyle.getShrinkToFit());
					xssfCellStyle.setTopBorderColor(cellStyle.getTopBorderColor());
					xssfCellStyle.setVerticalAlignment(cellStyle.getVerticalAlignmentEnum());
					xssfCellStyle.setWrapText(cellStyle.getWrapText());
					xssfCell.setCellStyle(xssfCellStyle);
					xssfCell.setCellType(cell.getCellTypeEnum());
					xssfCell.setHyperlink(cell.getHyperlink());
					CellType cellType = cell.getCellTypeEnum();
					switch (cellType) {
					case STRING:
						xssfCell.setCellValue(cell.getStringCellValue());
						 break;
					case BOOLEAN:
						  xssfCell.setCellValue(cell.getBooleanCellValue());;
						 break;
					case ERROR:
						xssfCell.setCellValue(cell.getErrorCellValue());
						 break;
					case FORMULA:// 公式
						 xssfCell.setCellValue(cell.getCellFormula());
						 break;
					case NUMERIC:// 公式
						// 如果为时间格式的内容
						xssfCell.setCellValue(cell.getNumericCellValue());
						 break;
					default:
						 break;
					}
				}
			}
		}
		return xssfWorkbook;
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
