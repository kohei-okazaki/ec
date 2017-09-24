package jp.co.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.site.dao.PurchaseDao;
import jp.co.site.entity.PurchaseItemEntity;
import jp.co.site.service.PurchaseSearchService;

/**
 * @author kou1210hei<br>
 * 購入商品検索サービス実装クラス<br>
 *
 */
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
	public List<PurchaseItemEntity> getPurchaseEntityByCustomerId(String customerId) {
		return dao.findPurchaseEntityByCustomerId(customerId);
	}


}
