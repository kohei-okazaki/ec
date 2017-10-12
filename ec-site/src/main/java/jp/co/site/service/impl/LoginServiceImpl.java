package jp.co.site.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.common.util.StringUtil;
import jp.co.site.form.LoginForm;
import jp.co.site.service.AccountSearchService;
import jp.co.site.service.LoginService;
import jp.co.site.web.session.EcSiteSessionKey;
import jp.co.site.web.session.EcsiteSessionManager;

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
	 * @return 判定結果
	 */
	@Override
	public boolean misMatch(LoginForm form) {

		if (StringUtil.isEmpty(form.getCustomerId()) || StringUtil.isEmpty(form.getPassword())) {
			return true;
		}

		String dbPassword = accountsearchService.findLoginUserByCustomerId(form.getCustomerId()).getPassword();
		String inputPassword = form.getPassword();
		return !dbPassword.equals(inputPassword);
	}

	/**
	 * セッション情報の確認<br>
	 * @param request
	 * @return 判定結果
	 */
	@Override
	public boolean sessionCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sessionCustomerId = EcsiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);
		String dbPassword = accountsearchService.findLoginUserByCustomerId(sessionCustomerId).getPassword();
		String sessionPassword = EcsiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.PASSWORD);
		return !dbPassword.equals(sessionPassword);
	}



}
