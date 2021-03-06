package jp.co.ec.site.service;

import javax.servlet.http.HttpServletRequest;

import jp.co.ec.site.form.LoginForm;

/**
 * @author kou1210hei<br>
 * ログインIF<br>
 *
 */
public interface LoginService {

	/**
	 * 顧客IDのログイン判定処理を行う<br>
	 * ログイン情報が不正であった場合, false<br>
	 * そうでない場合trueを返す<br>
	 * @param form
	 * @return 判定結果
	 */
	public boolean misMatch(LoginForm form);

	/**
	 * セッション情報の確認<br>
	 * @param request
	 * @return 判定結果
	 */
	public boolean sessionCheck(HttpServletRequest request);
}
