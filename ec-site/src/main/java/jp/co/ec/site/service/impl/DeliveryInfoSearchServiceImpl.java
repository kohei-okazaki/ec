package jp.co.ec.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ec.site.dao.DeliveryInfoDao;
import jp.co.ec.site.dto.DeliveryInfoDto;
import jp.co.ec.site.service.DeliveryInfoSearchService;

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
	public DeliveryInfoDto findDeliveryInfoByCustomerId(String customerId) {
		return deliveryInfoDao.getDeliveryInfoByCustomerId(customerId);
	}

}
