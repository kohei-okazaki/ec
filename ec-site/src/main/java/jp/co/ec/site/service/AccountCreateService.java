package jp.co.ec.site.service;

import jp.co.ec.common.dto.LoginUserDto;
import jp.co.ec.site.form.AccountCreateForm;

/**
 * @author kou1210hei<br>
 * アカウント作成サービスIF<br>
 *
 */
public interface AccountCreateService {

	/**
	 * パスワードのチェックを行う<br>
	 * @param form
	 * @return 判定結果
	 */
	public boolean invalidPassword(AccountCreateForm form);

	/**
	 * ログインユーザを作成する<br>
	 * @param form
	 * @return LoginUserEntity
	 */
	public void createLoginUser(LoginUserDto dto);

	/**
	 * Dto型に変換する<br>
	 * @param form
	 * @return
	 */
	public LoginUserDto toLoginUserDto(AccountCreateForm form);
}
