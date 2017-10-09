package jp.co.site.dao;

import java.util.List;

import jp.co.site.entity.PurchaseItemEntity;
import jp.co.site.form.PurchaseForm;

/**
 * @author kou1210hei<br>
 * 購入商品Dao<br>
 *
 */
public interface PurchaseDao {

	/**
	 * 顧客IDに紐付く購入商品情報を検索
	 * @param customerId
	 * @return 購入商品情報
	 */
	public List<PurchaseItemEntity> findPurchaseEntityByCustomerId(String customerId);

	/**
	 * 購入商品情報を登録する<br>
	 * @param form
	 */
	public void insertPurchaseInfo(PurchaseForm form);

}
