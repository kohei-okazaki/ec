package jp.co.site.service;

import jp.co.site.dto.DeliveryInfoDto;

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
	public DeliveryInfoDto findDeliveryInfoByCustomerId(String customerId);

}
