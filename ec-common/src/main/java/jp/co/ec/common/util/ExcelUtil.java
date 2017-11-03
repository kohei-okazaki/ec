package jp.co.ec.common.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import jp.co.ec.common.excel.Excel;


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
		return getExcelClass(clazz).sheetName();
	}

	/**
	 * Excelアノテーションに設定されたCell名をリストととして返す。<br>
	 * @param clazz
	 * @return cell名
	 */
	public static List<String> getHeaderList(Class<?> clazz) {
		return Arrays.asList(getExcelClass(clazz).cellNames());
	}

	/**
	 * 指定されたクラスにつけたExcelアノテーションを返す<br>
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
		if (Objects.isNull(sheetRow)) {
			sheetRow = sheet.createRow(row);
		}
		Cell cell = sheetRow.getCell(col);
		if (Objects.isNull(cell)) {
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
