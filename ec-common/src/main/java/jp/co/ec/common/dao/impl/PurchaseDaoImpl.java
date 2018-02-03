package jp.co.ec.common.dao.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.ec.common.dao.PurchaseDao;
import jp.co.ec.common.dto.PurchaseItemDto;
import jp.co.ec.common.util.DateUtil;

/**
 * @author kou1210hei<br>
 * 購入情報Dao実装クラス<br>
 *
 */
@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PurchaseItemDto> findPurchaseEntityByCustomerId(String customerId) throws ParseException {

		List<PurchaseItemDto> resultList = new ArrayList<PurchaseItemDto>();
		for (int i = 0; i < 20; i++) {
			PurchaseItemDto dto = new PurchaseItemDto();
			dto.setSeqCustomerId(customerId);
			if (i % 3 == 0) {
				dto.setItemName("リンゴ");
				dto.setItemPrice(200);
				dto.setItemCount(3);
				dto.setBuyDate(DateUtil.formatDate("20170904 12:56:43"));
			} else if (i % 8 == 0) {
				dto.setItemName("ミカン");
				dto.setItemPrice(350);
				dto.setItemCount(1);
				dto.setBuyDate(DateUtil.formatDate("20170904 11:56:43"));
			} else if (i % 5 == 0) {
				dto.setItemName("ブドウ");
				dto.setItemPrice(1000);
				dto.setItemCount(3);
				dto.setBuyDate(DateUtil.formatDate("20170806 12:56:43"));
			} else {
				dto.setItemName("メロン");
				dto.setItemPrice(3000);
				dto.setItemCount(1);
				dto.setBuyDate(DateUtil.formatDate("20170903 12:56:43"));
			}
			resultList.add(dto);
		}
		return resultList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertPurchaseInfo(PurchaseItemDto dto) {
		// FIXME 登録処理を実装
	}

}
