package jp.co.site.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.site.form.LoginForm;
import jp.co.site.service.AccountSearchService;
import jp.co.site.service.LoginService;
import jp.co.site.util.StringUtil;
import jp.co.site.web.session.EcSiteSessionKey;

/**
 * @author kou1210hei<br>
 * ログインIF実装クラス<br>
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	/** アカウント検索サービス */
	@Autowired
	private AccountSearchService accountsearchService;

	/**
	 * 顧客IDのログイン判定処理を行う<br>
	 * ログイン情報が不正であった場合, false<br>
	 * そうでない場合trueを返す<br>
	 * @param form
	 * @return
	 */
	@Override
	public boolean misMatch(LoginForm form) {

		if (StringUtil.isEmpty(form.getCustomerId()) || StringUtil.isEmpty(form.getPassword())) {
			return true;
		}

		String dbPassword = accountsearchService.findLoginUser(form.getCustomerId()).getPassword();
		String inputPassword = form.getPassword();
		return !dbPassword.equals(inputPassword);
	}

	/**
	 * セッション情報の確認<br>
	 * @param request
	 * @return
	 */
	@Override
	public boolean sessionCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionCustomerId = (String) session.getAttribute(EcSiteSessionKey.CUSTOMER_ID.getName());
		String accountPassword = accountsearchService.findLoginUser(sessionCustomerId).getPassword();
		String sessionPassword = (String) session.getAttribute(EcSiteSessionKey.PASSWORD.getName());
		return !accountPassword.equals(sessionPassword);
	}



}
