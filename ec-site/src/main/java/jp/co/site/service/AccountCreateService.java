package jp.co.site.service;

import jp.co.site.entity.LoginUserEntity;
import jp.co.site.form.AccountCreateForm;

/**
 * @author kou1210hei<br>
 * アカウント作成サービスIF<br>
 *
 */
public interface AccountCreateService {

	/**
	 * パスワードのチェックを行う<br>
	 * @param form
	 * @return
	 */
	public boolean invalidPassword(AccountCreateForm form);

	/**
	 * ログインユーザを作成する<br>
	 * @return
	 */
	public LoginUserEntity createLoginUser(AccountCreateForm form);
}
