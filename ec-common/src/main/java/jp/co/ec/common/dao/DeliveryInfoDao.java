package jp.co.ec.common.dao;

import jp.co.ec.common.dto.DeliveryInfoDto;

/**
 * @author kou1210hei<br>
 * 配送先情報のdao<br>
 *
 */
public interface DeliveryInfoDao {

	/**
	 * 配送先情報を作成<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	void createDeliveryInfo(DeliveryInfoDto dto);

	/**
	 * 配送先情報を更新する<br>
	 * @param dto
	 */
	void updateDeliveryInfo(DeliveryInfoDto dto);

	/**
	 * 顧客IDに紐づく配送先情報を取得<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	DeliveryInfoDto findDeliveryInfoByCustomerId(String customerId);
}
