package jp.co.ec.site.service;

import java.text.ParseException;
import java.util.List;

import jp.co.ec.common.dto.PurchaseItemDto;

/**
 * @author kou1210hei<br>
 * 購入商品検索サービスIF<br>
 *
 */
public interface PurchaseSearchService {

	/**
	 * 顧客IDに紐付く商品購入情報を検索する<br>
	 * @param customerId
	 * @return 商品購入情報のリスト
	 */
	public List<PurchaseItemDto> findPurchaseEntityByCustomerId(String customerId) throws ParseException;
}
