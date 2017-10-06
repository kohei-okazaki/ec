package jp.co.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;
import jp.co.site.web.session.EcsiteSessionManager;

/**
 * @author kou1210hei<br>
 * ログインコントローラ<br>
 *
 */
@Controller
public class LoginController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * ログイン画面<br>
	 * ログイン画面描画時にセッション情報を削除<br>
	 * @param model
	 * @param request
	 * @return ログイン画面
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {

		LOG.info(this.getClass().getSimpleName() + "#login");

		HttpSession session = request.getSession();
		EcsiteSessionManager.getInstance().removeKey(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);
		return View.LOGIN.getName();
	}

}
