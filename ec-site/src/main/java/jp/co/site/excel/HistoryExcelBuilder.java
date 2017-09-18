package jp.co.site.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import jp.co.common.excel.BaseExcelBuilder;
import jp.co.common.other.Property;
import jp.co.common.util.Charset;
import jp.co.common.util.ExcelUtil;
import jp.co.site.entity.PurchaseItemEntity;

/**
 * @author kou1210hei<br>
 * エクセル出力クラス<be>
 *
 */
@Property("購入商品情報")
public class HistoryExcelBuilder extends BaseExcelBuilder {

	/** 購入商品リスト */
	private List<PurchaseItemEntity> purchaseList;

	/**
	 * コンストラクタ<br>
	 * @param purchaseList
	 */
	public HistoryExcelBuilder(List<PurchaseItemEntity> purchaseList) {
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

		String fileName = new String("sample.xlsx".getBytes(Charset.MS_932.getName()), "ISO-8859-1");
		response.setHeader("Content-Desposition", "attachment; filename=" + fileName);

		Sheet sheet;
		Cell cell = null;

		sheet = workbook.createSheet("購入商品情報");
		setHeader(sheet, cell);

		cell = ExcelUtil.getCell(sheet, 1, 0);

		// 購入商品情報を1レコードずつ設定する
		for (int i = 0; i < purchaseList.size(); i++) {
			cell = ExcelUtil.getCell(sheet, i + 1, 0);
			ExcelUtil.setText(cell, purchaseList.get(i).getItemName());
			cell = ExcelUtil.getCell(sheet, i + 1, 1);
			ExcelUtil.setText(cell, purchaseList.get(i).getItemCount().toString());
			cell = ExcelUtil.getCell(sheet, i + 1, 2);
			ExcelUtil.setText(cell, purchaseList.get(i).getItemPrice().toString());
		}


	}

	/**
	 * ヘッダーを設定する<br>
	 * @param sheet
	 * @param cell
	 */
	@Override
	protected void setHeader(Sheet sheet, Cell cell) {
		// ヘッダ設定
		cell = ExcelUtil.getCell(sheet, 0, 0);
		ExcelUtil.setText(cell, "商品名");
		cell = ExcelUtil.getCell(sheet, 0, 1);
		ExcelUtil.setText(cell, "購入商品数");
		cell = ExcelUtil.getCell(sheet, 0, 2);
		ExcelUtil.setText(cell, "単価");
	}

}
