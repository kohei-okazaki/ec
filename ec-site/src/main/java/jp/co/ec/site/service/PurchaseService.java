package jp.co.ec.site.service;

import jp.co.ec.site.form.PurchaseForm;

/**
 * @author kou1210hei<br>
 * 購入商品のサービスIF<br>
 *
 */
public interface PurchaseService {

	/**
	 * 購入商品のチェックを行う<br>
	 * @param form
	 * @return 判定結果
	 */
	public boolean checkPurchaseItem(PurchaseForm form);

	/**
	 * 商品購入処理を行う。<br>
	 * @param form
	 */
	public void registPurchaseItem(PurchaseForm form);


}
