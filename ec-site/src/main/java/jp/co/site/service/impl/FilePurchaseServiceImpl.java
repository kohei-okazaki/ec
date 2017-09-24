package jp.co.site.service.impl;

import org.springframework.stereotype.Service;

import jp.co.site.form.FilePurchaseForm;
import jp.co.site.service.FilePurchaseService;

/**
 * @author kou1210hei<br>
 * ファイル一括購入サービス実装クラス<br>
 *
 */
@Service
public class FilePurchaseServiceImpl implements FilePurchaseService {

	@Override
	public FilePurchaseForm setFilePurchaseForm() {
		return new FilePurchaseForm();
	}

}
