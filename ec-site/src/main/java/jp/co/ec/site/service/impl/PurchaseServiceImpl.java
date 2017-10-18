package jp.co.ec.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ec.common.util.StringUtil;
import jp.co.ec.site.dao.PurchaseDao;
import jp.co.ec.site.form.PurchaseForm;
import jp.co.ec.site.service.PurchaseService;

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
