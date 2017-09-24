package jp.co.site.dao;

import java.util.List;

import jp.co.site.entity.PurchaseItemEntity;

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

}
