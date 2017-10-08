package jp.co.site.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import jp.co.site.other.Excel;

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
	 * Excelアノテーションに設定されたシート名を返す。<br>
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
	public static List<String> getHeaderList(Class<?> clazz) {
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
