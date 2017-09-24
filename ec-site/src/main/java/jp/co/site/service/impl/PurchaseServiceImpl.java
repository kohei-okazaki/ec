package jp.co.site.service.impl;

import org.springframework.stereotype.Service;

import jp.co.site.form.PurchaseForm;
import jp.co.site.service.PurchaseService;
import jp.co.site.util.StringUtil;

/**
 * @author kou1210hei<br>
 * 購入商品サービス実装クラス<br>
 *
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	/**
	 * 購入商品のチェックを行う<br>
	 * @param form
	 * @return 判定結果
	 */
	@Override
	public boolean checkPurchaseItem(PurchaseForm form) {
		return StringUtil.isEmpty(form.getItemName())
			|| StringUtil.isEmpty(form.getItemCount().toString())
			|| StringUtil.isEmpty(form.getItemPrice().toString());
	}

}
