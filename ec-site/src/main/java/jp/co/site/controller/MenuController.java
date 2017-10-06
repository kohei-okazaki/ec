package jp.co.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.site.form.LoginForm;
import jp.co.site.service.LoginService;
import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;
import jp.co.site.web.session.EcsiteSessionManager;

/**
 * @author kou1210hei<br>
 * メニュー画面コントローラ<br>
 *
 */
@Controller
public class MenuController {

	/** ログイン画面サービス */
	@Autowired
	private LoginService loginService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass().getSimpleName());

	/**
	 * メニュー画面<br>
	 * ログインフォームからの遷移の場合<br>
	 * @param form
	 * @param model
	 * @param request
	 * @return メニュー画面
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.POST)
	public String menu(LoginForm form, Model model, HttpServletRequest request) {

		LOG.info(this.getClass().getSimpleName() + "#menu");

		if (loginService.misMatch(form)) {
			return View.LOGIN.getName();
		}

		HttpSession session = request.getSession();
		EcsiteSessionManager manager = EcsiteSessionManager.getInstance();
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
	@RequestMapping(value = "/menu.html", method = RequestMethod.GET)
	public String menu(Model model, HttpServletRequest request) {

		LOG.info(this.getClass().getSimpleName() + "#menu");

		if (loginService.sessionCheck(request)) {
			// セッション情報が不正の場合
			return View.LOGIN.getName();
		}

		return View.MENU.getName();
	}

}
