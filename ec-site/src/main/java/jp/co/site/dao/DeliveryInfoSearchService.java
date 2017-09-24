package jp.co.site.dao;

import jp.co.site.entity.DeliveryInfoEntity;

/**
 * @author kou1210hei<br>
 * 配送先情報検索サービス<br>
 */
public interface DeliveryInfoSearchService {

	/**
	 * 顧客IDから配送先情報を取得する<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	public DeliveryInfoEntity findDeliveryInfoByCustomerId(String customerId);

}
