package jp.co.site.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import jp.co.site.dao.DeliveryInfoDao;
import jp.co.site.entity.DeliveryInfoEntity;

@Repository
public class DeliveryInfoDaoImpl implements DeliveryInfoDao {

	/**
	 * 配送先情報を作成<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	@Override
	public DeliveryInfoEntity createDeliveryInfo(String customerId) {
		DeliveryInfoEntity entity = new DeliveryInfoEntity();
		entity.setSeqCustomerId(customerId);
		entity.setPrefectures("東京都");
		entity.setCity("渋谷区");
		entity.setAddress("渋谷");
		entity.setRegDate(new Date());
		return entity;
	}

	/**
	 * 配送先情報を更新する<br>
	 * @param deliveryInfoEntity
	 */
	@Override
	public void updateDeliveryInfo(DeliveryInfoEntity deliveryInfoEntity) {

	}

	/**
	 * 顧客IDに紐づく配送先情報を取得<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	@Override
	public DeliveryInfoEntity getDeliveryInfoByCustomerId(String customerId) {
		// FIXME
		DeliveryInfoEntity entity = new DeliveryInfoEntity();
		entity.setSeqCustomerId(customerId);
		entity.setPrefectures("千葉県");
		entity.setCity("松戸市");
		entity.setAddress("松戸");
		entity.setRegDate(new Date());
		return entity;
	}

}
