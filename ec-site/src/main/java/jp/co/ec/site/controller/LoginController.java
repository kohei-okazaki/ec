package jp.co.ec.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ec.site.log.EcSiteLogger;
import jp.co.ec.site.web.session.EcSiteSessionKey;
import jp.co.ec.site.web.session.EcSiteSessionManager;
import jp.co.ec.site.web.view.View;

/**
 * @author kou1210hei<br>
 * ログインコントローラ<br>
 *
 */
@Controller
public class LoginController {

	/**
	 * ログイン画面<br>
	 * ログイン画面描画時にセッション情報を削除<br>
	 * @param model
	 * @param reques
	 * @return ログイン画面
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {

		EcSiteLogger.getInstance().info(this.getClass(), " # login");

		HttpSession session = request.getSession();
		EcSiteSessionManager.getInstance().removeKey(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);
		return View.LOGIN.getName();
	}

}
