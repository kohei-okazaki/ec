package jp.co.site.service;

import java.util.List;

import jp.co.site.form.PurchaseForm;

/**
 * @author kou1210hei<br>
 * 購入商品のサービスIF<br>
 *
 */
public interface PurchaseService {

	/**
	 * 商品リストを返却する
	 * @return
	 */
	public List<PurchaseForm> getAllItemList();

	/**
	 * 購入商品のチェックを行う<br>
	 * @param form
	 * @return
	 */
	public boolean checkPurchaseItem(PurchaseForm form);


}
