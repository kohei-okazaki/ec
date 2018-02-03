package jp.co.ec.common.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import jp.co.ec.common.dao.DeliveryInfoDao;
import jp.co.ec.common.dto.DeliveryInfoDto;

@Repository
public class DeliveryInfoDaoImpl implements DeliveryInfoDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createDeliveryInfo(DeliveryInfoDto dto) {
		// FIXME
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateDeliveryInfo(DeliveryInfoDto dto) {
		// FIXME
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DeliveryInfoDto findDeliveryInfoByCustomerId(String customerId) {
		// FIXME
		DeliveryInfoDto dto = new DeliveryInfoDto();
		dto.setSeqCustomerId(customerId);
		dto.setPrefectures("千葉県");
		dto.setCity("松戸市");
		dto.setAddress("松戸");
		dto.setRegDate(new Date());
		return dto;
	}

}
