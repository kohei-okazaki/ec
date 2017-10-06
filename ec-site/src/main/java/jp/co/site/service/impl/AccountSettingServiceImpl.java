package jp.co.site.service.impl;

import org.springframework.stereotype.Service;

import jp.co.site.form.AccountSettingForm;
import jp.co.site.service.AccountSettingService;

/**
 * @author kou1210hei<br>
 * アカウント設定サービス実装クラス<br>
 *
 */
@Service
public class AccountSettingServiceImpl implements AccountSettingService {

	@Override
	public boolean invalidForm(AccountSettingForm form) {
		return true;
	}

}
