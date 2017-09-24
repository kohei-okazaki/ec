package jp.co.site.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.site.dao.DeliveryInfoDao;
import jp.co.site.dao.DeliveryInfoSearchService;
import jp.co.site.entity.DeliveryInfoEntity;

/**
 * @author kou1210hei<br>
 * 配送先情報検索サービス実装クラス<br>
 *
 */
@Service
public class DeliveryInfoSearchServiceImpl implements DeliveryInfoSearchService {

	/** 配送先情報Dao */
	@Autowired
	private DeliveryInfoDao deliveryInfoDao;

	/**
	 * 顧客IDから配送先情報を取得する<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	@Override
	public DeliveryInfoEntity findDeliveryInfoByCustomerId(String customerId) {
		return deliveryInfoDao.getDeliveryInfoByCustomerId(customerId);
	}

}
