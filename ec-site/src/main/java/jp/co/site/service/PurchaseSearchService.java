package jp.co.site.service;

import java.util.List;

import jp.co.site.entity.PurchaseItemEntity;

/**
 * @author kou1210hei<br>
 * 購入商品検索サービスIF<br>
 *
 */
public interface PurchaseSearchService {

	/**
	 * 顧客IDに紐付く商品購入情報を検索する<br>
	 * @param customerId
	 * @return 商品購入情報のリスト
	 */
	public List<PurchaseItemEntity> findPurchaseEntityByCustomerId(String customerId);
}
