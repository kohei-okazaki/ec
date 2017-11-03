package jp.co.ec.site.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jp.co.ec.common.excel.BaseExcelBuilder;
import jp.co.ec.common.excel.Excel;
import jp.co.ec.common.other.Charset;
import jp.co.ec.common.util.ExcelUtil;
import jp.co.ec.site.dto.PurchaseItemDto;


/**
 * @author kou1210hei<br>
 * エクセル出力クラス<be>
 *
 */
@Excel(sheetName = "購入商品情報", cellNames = {"商品名", "購入商品数", "単価"})
public class HistoryExcelBuilder extends BaseExcelBuilder {

	/** 購入商品リスト */
	private List<PurchaseItemDto> purchaseList;

	/**
	 * コンストラクタ<br>
	 * @param purchaseList
	 */
	public HistoryExcelBuilder(List<PurchaseItemDto> purchaseList) {
		this.purchaseList = purchaseList;
	}

	/**
	 * エクセルに情報を書き込む<br>
	 * @param model
	 * @param workbook
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> model
									, Workbook workbook
									, HttpServletRequest request
									, HttpServletResponse response) throws Exception {

		String fileName = new String("sample.xls".getBytes(Charset.MS_932.getName()), "ISO-8859-1");
		response.setHeader("Content-Desposition", "attachment; filename=" + fileName);

		Sheet sheet = workbook.createSheet(ExcelUtil.getSheetName(this.getClass()));

		setHeader(sheet);

		setData(sheet);
	}

	/**
	 * ヘッダーを設定する<br>
	 * @param sheet
	 * @param cell
	 */
	@Override
	protected void setHeader(Sheet sheet) {
		List<String> headerNameList = ExcelUtil.getHeaderList(this.getClass());
		for (int i = 0; i < headerNameList.size(); i++) {
			String cellName = headerNameList.get(i);
			Cell cell = ExcelUtil.getCell(sheet, 0, i);
			ExcelUtil.setText(cell, cellName);
		}
	}

	/**
	 * データを設定する<br>
	 * @param sheet
	 */
	@Override
	protected void setData(Sheet sheet) {

		// 購入商品情報を1レコードずつ設定する
		for (int i = 0; i < purchaseList.size(); i++) {
			Cell cell = ExcelUtil.getCell(sheet, i + 1, 0);
			ExcelUtil.setText(cell, purchaseList.get(i).getItemName());
			cell = ExcelUtil.getCell(sheet, i + 1, 1);
			ExcelUtil.setText(cell, purchaseList.get(i).getItemCount().toString());
			cell = ExcelUtil.getCell(sheet, i + 1, 2);
			ExcelUtil.setText(cell, purchaseList.get(i).getItemPrice().toString());
		}
	}

}
