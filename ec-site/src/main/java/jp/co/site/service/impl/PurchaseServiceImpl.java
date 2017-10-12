package jp.co.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.common.util.StringUtil;
import jp.co.site.dao.PurchaseDao;
import jp.co.site.form.PurchaseForm;
import jp.co.site.service.PurchaseService;

/**
 * @author kou1210hei<br>
 * 購入商品サービス実装クラス<br>
 *
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	/** 購入商品Dao */
	@Autowired
	private PurchaseDao purchaseDao;

	/**
	 * 購入商品のチェックを行う<br>
	 * @param form
	 * @return 判定結果
	 */
	@Override
	public boolean checkPurchaseItem(PurchaseForm form) {
		return StringUtil.isEmpty(form.getItemName())
			|| StringUtil.isEmpty(form.getItemCount().toString())
			|| StringUtil.isEmpty(form.getItemPrice().toString())
			|| StringUtil.isEmpty(form.getPaymentMethod())
			|| StringUtil.isEmpty(form.getPaymentCount().toString());
	}

	/**
	 * 商品購入処理を行う。<br>
	 * @param form
	 */
	@Override
	public void registPurchaseItem(PurchaseForm form) {
		purchaseDao.insertPurchaseInfo(form);
	}

}
