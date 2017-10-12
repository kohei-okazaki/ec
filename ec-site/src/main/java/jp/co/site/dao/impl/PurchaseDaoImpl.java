package jp.co.site.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.site.dao.PurchaseDao;
import jp.co.site.dto.PurchaseItemDto;
import jp.co.site.form.PurchaseForm;

/**
 * @author kou1210hei<br>
 * 購入商品Dao実装クラス<br>
 *
 */
@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	/**
	 * 顧客IDに紐付く購入商品情報を検索
	 * @param customerId
	 * @return 購入商品情報
	 */
	@Override
	public List<PurchaseItemDto> findPurchaseEntityByCustomerId(String customerId) {

		List<PurchaseItemDto> resultList = new ArrayList<PurchaseItemDto>();
		for (int i = 0; i < 20; i++) {
			PurchaseItemDto dto = new PurchaseItemDto();
			dto.setSeqCustomerId(customerId);
			if (i % 3 == 0) {
				dto.setItemName("リンゴ");
				dto.setItemPrice(200);
				dto.setItemCount(3);
			} else if (i % 8 == 0) {
				dto.setItemName("ミカン");
				dto.setItemPrice(350);
				dto.setItemCount(1);
			} else if (i % 5 == 0) {
				dto.setItemName("ブドウ");
				dto.setItemPrice(1000);
				dto.setItemCount(3);
			} else {
				dto.setItemName("メロン");
				dto.setItemPrice(3000);
				dto.setItemCount(1);
			}
			resultList.add(dto);
		}
		return resultList;
	}

	/**
	 * 購入商品情報を登録する<br>
	 * @param form
	 */
	@Override
	public void insertPurchaseInfo(PurchaseForm form) {
		// TODO 登録処理を実装
	}

}
