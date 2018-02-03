package jp.co.ec.common.dao;

import java.text.ParseException;
import java.util.List;

import jp.co.ec.common.dto.PurchaseItemDto;


/**
 * @author kou1210hei<br>
 * 購入商品Dao<br>
 *
 */
public interface PurchaseDao {

	/**
	 * 顧客IDに紐付く購入商品情報を検索
	 * @param customerId
	 * @return 購入商品情報
	 */
	public List<PurchaseItemDto> findPurchaseEntityByCustomerId(String customerId) throws ParseException;

	/**
	 * 購入商品情報を登録する<br>
	 * @param form
	 */
	public void insertPurchaseInfo(PurchaseItemDto dto);

}
