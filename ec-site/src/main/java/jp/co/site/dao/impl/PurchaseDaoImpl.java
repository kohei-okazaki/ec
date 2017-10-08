package jp.co.site.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.site.dao.PurchaseDao;
import jp.co.site.entity.PurchaseItemEntity;
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
	public List<PurchaseItemEntity> findPurchaseEntityByCustomerId(String customerId) {

		List<PurchaseItemEntity> resultList = new ArrayList<PurchaseItemEntity>();
		for (int i = 0; i < 20; i++) {
			PurchaseItemEntity entity = new PurchaseItemEntity();
			entity.setSeqCustomerId(customerId);
			if (i % 3 == 0) {
				entity.setItemName("リンゴ");
				entity.setItemPrice(200);
				entity.setItemCount(3);
			} else if (i % 8 == 0) {
				entity.setItemName("ミカン");
				entity.setItemPrice(350);
				entity.setItemCount(1);
			} else if (i % 5 == 0) {
				entity.setItemName("ブドウ");
				entity.setItemPrice(1000);
				entity.setItemCount(3);
			} else {
				entity.setItemName("メロン");
				entity.setItemPrice(3000);
				entity.setItemCount(1);
			}
			resultList.add(entity);
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
