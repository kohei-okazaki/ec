package jp.co.ec.site.service.impl;

import org.springframework.stereotype.Service;

import jp.co.ec.site.form.AccountSettingForm;
import jp.co.ec.site.service.AccountSettingService;

@Service
public class AccountSettingServiceImpl implements AccountSettingService {

	@Override
	public boolean invalidForm(AccountSettingForm form) {
		return true;
	}

}
