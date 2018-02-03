package jp.co.ec.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.ec.site.form.LoginForm;
import jp.co.ec.site.log.EcSiteLogger;
import jp.co.ec.site.service.LoginService;
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

	/** ログインサービス */
	@Autowired
	private LoginService loginService;

	/**
	 * ログイン画面<br>
	 * ログイン画面描画時にセッション情報を削除<br>
	 * @param model
	 * @param reques
	 * @return ログイン画面
	 */
	@GetMapping(value = "/login.html")
	public String login(Model model, HttpServletRequest request) {

		EcSiteLogger.getInstance().info(this.getClass(), " # login");

		HttpSession session = request.getSession();
		EcSiteSessionManager.getInstance().removeKey(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);

		return View.LOGIN.getName();
	}

	/**
	 * メニュー画面<br>
	 * ログインフォーム画面からの遷移の場合<br>
	 * @param form
	 * @param model
	 * @param request
	 * @return メニュー画面
	 */
	@PostMapping("/menu.html")
	public String menu(LoginForm form, Model model, HttpServletRequest request) {

		EcSiteLogger.getInstance().info(this.getClass(), " # menu");

		if (loginService.misMatch(form)) {
			return View.LOGIN.getName();
		}

		HttpSession session = request.getSession();
		EcSiteSessionManager manager = EcSiteSessionManager.getInstance();
		manager.setAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID, form.getCustomerId());
		manager.setAttribute(session, EcSiteSessionKey.PASSWORD, form.getPassword());

		return View.MENU.getName();
	}

	/**
	 * セッション情報からのメニュー画面遷移<br>
	 * @param model
	 * @param request
	 * @return メニュー画面
	 */
	@GetMapping("/menu.html")
	public String menu(Model model, HttpServletRequest request) {

		EcSiteLogger.getInstance().info(this.getClass(), " # menu");

		if (loginService.sessionCheck(request)) {
			// セッション情報が不正の場合
			return View.LOGIN.getName();
		}

		return View.MENU.getName();
	}

}
