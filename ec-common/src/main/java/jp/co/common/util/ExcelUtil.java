package jp.co.common.util;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import jp.co.common.other.Excel;

/**
 * @author kou1210hei<br>
 * ExcelのUtilクラス<br>
 *
 */
public class ExcelUtil {

	/**
	 * インスタンス生成を制限
	 */
	private ExcelUtil() {
	}

	/**
	 * Excelアノテーションに設定されたシート名をリストととして返す。<br>
	 * @param clazz
	 * @return シート名
	 */
	public static String getSheetName(Class<?> clazz) {
		Excel excel = getExcelClass(clazz);
		return excel.sheetName();
	}

	/**
	 * Excelアノテーションに設定されたCell名をリストととして返す。<br>
	 * @param clazz
	 * @return cell名
	 */
	public static List<String> getCellList(Class<?> clazz) {
		Excel excel = getExcelClass(clazz);
		return Arrays.asList(excel.cellNames());
	}

	/**
	 * 指定されたクラス型のExcelアノテーションを返す<br>
	 * @param clazz
	 * @return
	 */
	private static Excel getExcelClass(Class<?> clazz) {
		return (Excel) clazz.getAnnotation(Excel.class);
	}

	/**
	 * セルを返す<br>
	 * @param sheet
	 * @param row
	 * @param col
	 * @return cell
	 */
	public static Cell getCell(Sheet sheet, int row, int col) {
		Row sheetRow = sheet.getRow(row);
		if (sheetRow == null) {
			sheetRow = sheet.createRow(row);
		}
		Cell cell = sheetRow.getCell(col);
		if (cell == null) {
			cell = sheetRow.createCell(col);
		}
		return cell;
	}

	/**
	 * 指定されたセルにtextを設定する<br>
	 * @param cell
	 * @param text
	 */
	public static void setText(Cell cell, String text) {
		cell.setCellType(CellType.STRING);
		cell.setCellValue(text);
	}
}
