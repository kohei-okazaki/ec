package jp.co.ec.common.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import jp.co.ec.common.dao.DeliveryInfoDao;
import jp.co.ec.common.dto.DeliveryInfoDto;

@Repository
public class DeliveryInfoDaoImpl implements DeliveryInfoDao {

	/**
	 * 配送先情報を作成<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	@Override
	public DeliveryInfoDto createDeliveryInfo(String customerId) {
		DeliveryInfoDto dto = new DeliveryInfoDto();
		dto.setSeqCustomerId(customerId);
		dto.setPrefectures("東京都");
		dto.setCity("渋谷区");
		dto.setAddress("渋谷");
		dto.setRegDate(new Date());
		return dto;
	}

	/**
	 * 配送先情報を更新する<br>
	 * @param dto
	 */
	@Override
	public void updateDeliveryInfo(DeliveryInfoDto dto) {

	}

	/**
	 * 顧客IDに紐づく配送先情報を取得<br>
	 * @param customerId
	 * @return 配送先情報
	 */
	@Override
	public DeliveryInfoDto getDeliveryInfoByCustomerId(String customerId) {
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
