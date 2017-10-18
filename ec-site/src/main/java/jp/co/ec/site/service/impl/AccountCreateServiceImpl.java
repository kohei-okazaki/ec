package jp.co.ec.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ec.common.util.StringUtil;
import jp.co.ec.site.dao.LoginUserDao;
import jp.co.ec.site.dto.LoginUserDto;
import jp.co.ec.site.form.AccountCreateForm;
import jp.co.ec.site.service.AccountCreateService;

@Service
public class AccountCreateServiceImpl implements AccountCreateService {

	/** ログインユーザDao */
	@Autowired
	private LoginUserDao dao;

	/**
	 * パスワードのチェックを行う<br>
	 * 無効なログイン情報の場合true, 正常なログイン情報の場合falseを返す<br>
	 * @param form
	 * @return 判定結果を返す
	 */
	@Override
	public boolean invalidPassword(AccountCreateForm form) {

		StringUtil.isEquals(form.getPassword(), form.getConfirmPassword());
		if (StringUtil.isEmpty(form.getPassword()) || StringUtil.isEmpty(form.getConfirmPassword())) {
			return true;
		}
		return !StringUtil.isEquals(form.getPassword(), form.getConfirmPassword());
	}

	/**
	 * ログインユーザを作成する<br>
	 * @param form
	 * @return LoginUserEntity
	 */
	@Override
	public LoginUserDto createLoginUser(AccountCreateForm form) {
		return dao.createLoginUser(form.getPassword());
	}

}
