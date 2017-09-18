package jp.co.site.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.common.util.StringUtil;
import jp.co.site.form.PurchaseForm;
import jp.co.site.service.PurchaseService;

/**
 * @author kou1210hei<br>
 * 購入商品サービス実装クラス<br>
 *
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	/**
	 * 商品リストを返却する
	 * @return
	 */
	@Override
	public List<PurchaseForm> getAllItemList() {
		List<PurchaseForm> itemList = new ArrayList<PurchaseForm>();

		for (int i = 0; i < 3; i++) {
			PurchaseForm form = new PurchaseForm();
			if (i == 0) {
				form.setItemName("リンゴ");
				form.setItemPrice(500);
			} else if (i == 1) {
				form.setItemName("ミカン");
				form.setItemPrice(100);
			} else {
				form.setItemName("ブドウ");
				form.setItemPrice(200);
			}
			itemList.add(form);
		}
		return itemList;
	}

	/**
	 * 購入商品のチェックを行う<br>
	 * @param form
	 * @return
	 */
	@Override
	public boolean checkPurchaseItem(PurchaseForm form) {
		return StringUtil.isEmpty(form.getItemName())
			|| StringUtil.isEmpty(form.getItemCount().toString())
			|| StringUtil.isEmpty(form.getItemPrice().toString());
	}

}
