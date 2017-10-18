package jp.co.ec.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ec.site.dao.PurchaseDao;
import jp.co.ec.site.dto.PurchaseItemDto;
import jp.co.ec.site.service.PurchaseSearchService;

@Service
public class PurchaseSearchServiceImpl implements PurchaseSearchService {

	/** 購入商品Dao */
	@Autowired
	private PurchaseDao dao;

	/**
	 * 顧客IDに紐付く商品購入情報を検索する<br>
	 * @param customerId
	 * @return 商品購入情報のリスト
	 */
	@Override
	public List<PurchaseItemDto> findPurchaseEntityByCustomerId(String customerId) {
		return dao.findPurchaseEntityByCustomerId(customerId);
	}

}
