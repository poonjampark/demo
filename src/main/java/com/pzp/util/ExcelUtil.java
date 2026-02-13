package com.pzp.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
 * Excel工具类
 * 
 * @author panzhanpeng
 *
 */
public class ExcelUtil {
	
	public static final String XLS = ".xls";
	public static final String XLSX = ".xlsx";

	public static <T> List<T> readExcelFileToDTO(MultipartFile file, Class<T> clazz, Map<String, String> mapping) throws IOException {
		return readExcelFileToDTO(file, clazz, 0, mapping);
	}

	public static <T> List<T> readExcelFileToDTO(MultipartFile file, Class<T> clazz, Integer sheetId, Map<String, String> mapping)
			throws IOException {
		Workbook workbook = buildWorkbook(file);
		return readSheetToDTO(workbook.getSheetAt(sheetId), clazz, mapping);
	}
	
	/**
	 * 构建工作对象
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private static Workbook buildWorkbook(MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		if (filename.endsWith(XLS)) {
			return new HSSFWorkbook(file.getInputStream());
		} else if (filename.endsWith(XLSX)) {
			return new XSSFWorkbook(file.getInputStream());
		} else {
			throw new IOException("文件格式类型错误: " + filename);
		}
	}

	public static <T> List<T> readSheetToDTO(Sheet sheet, Class<T> clazz, Map<String, String> mapping) throws IOException {
		List<T> result = new ArrayList<>();
		List<Map<String, String>> sheetValue = changeSheetToMapList(sheet);
		for (Map<String, String> valueMap : sheetValue) {
			T dto = buildDTOByClass(clazz, valueMap, mapping);
			if (dto != null) {
				result.add(dto);
			}
		}
		return result;
	}

	/**
	 * 把excel表格遍历，把表头和每一行值以放进map，然后再放进list
	 * 
	 * @param sheet
	 * @return
	 */
	private static List<Map<String, String>> changeSheetToMapList(Sheet sheet) {
		List<Map<String, String>> result = new ArrayList<>();
		int rowNumber = sheet.getPhysicalNumberOfRows();
		List<String> titles = getSheetRowValues(sheet.getRow(0));
		try {
			for (int i = 1; i < rowNumber; i++) {
				List<String> values = getSheetRowValues(sheet.getRow(i));
				Map<String, String> valueMap = new HashMap<>();
				for (int j = 0; j < titles.size(); j++) {
					valueMap.put(titles.get(j), values.get(j));
				}
				result.add(valueMap);
			}
		} catch (Exception e) {
			System.out.println();
		}
		
		return result;
	}
	
	/**
	 * 获取单元格值集合
	 * @param row
	 * @return
	 */
	private static List<String> getSheetRowValues(Row row) {
		List<String> cellValueList = new ArrayList<>();
		if (row != null) {
			int cellNumber = row.getLastCellNum();
			for (int i = 0; i < cellNumber; i++) {
				cellValueList.add(getCellValue(row.getCell(i)));
			}
		}
		return cellValueList;
	}
	
	/**
	 * 判断单元格值的格式
	 * @param row
	 * @return
	 */
	private static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell != null && !"".equals(cell.toString().trim())) {
			if (cell.getCellType() == CellType.STRING) {
				cellValue = cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC) {
				cellValue = new DecimalFormat("#.######").format(cell.getNumericCellValue());
			} else if (cell.getCellType() == CellType.BOOLEAN) {
				cellValue = String.valueOf(cell.getBooleanCellValue());
			}
		}
		return cellValue;
	}

	/**
	 * 将表格一行的值对应上类的值并set进去
	 * 
	 * @param <T>
	 * @param clazz
	 * @param valueMap
	 * @return
	 */
	private static <T> T buildDTOByClass(Class<T> clazz, Map<String, String> valueMap, Map<String, String> mapping) {
		try {
			T dto = clazz.newInstance();
			for (Field field : clazz.getDeclaredFields()) {
				if (!"id".equals(field.getName())) {
					Method method = clazz.getMethod(getSetMethodName(field.getName()), field.getType());
					method.invoke(dto, valueMap.get(mapping.get(field.getName())));
				}
			}
			return dto;
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	/**
	 * 获取set方法名称
	 * 
	 * @param name
	 * @return
	 */
	private static String getSetMethodName(String name) {
		String firstChar = name.substring(0, 1);
		return "set" + firstChar.toUpperCase() + name.substring(1);
	}

}