package jp.co.site.dao;

import jp.co.site.entity.DeliveryInfoEntity;

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
	public DeliveryInfoEntity createDeliveryInfo(String customerId);

	/**
	 * 配送先情報を更新する<br>
	 * @param deliveryInfoEntity
	 */
	public void updateDeliveryInfo(DeliveryInfoEntity deliveryInfoEntity);

	/**
	 * 顧客IDに紐づく配送先情報を取得<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	public DeliveryInfoEntity getDeliveryInfoByCustomerId(String customerId);
}
