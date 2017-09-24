package jp.co.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.site.form.LoginForm;
import jp.co.site.service.LoginService;
import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;

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

	/**
	 * メニュー画面<br>
	 * ログインフォームからの遷移の場合<br>
	 * @param locale
	 * @param form
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.POST)
	public String menu(LoginForm form, Model model, HttpServletRequest request) {

		if (loginService.misMatch(form)) {
			return View.LOGIN.getName();
		}

		HttpSession session = request.getSession();
		session.setAttribute(EcSiteSessionKey.SEQ_CUSTOMER_ID.getName(), form.getCustomerId());
		session.setAttribute(EcSiteSessionKey.PASSWORD.getName(), form.getPassword());

		return View.MENU.getName();
	}

	/**
	 * セッション情報からのメニュー画面遷移<br>
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/menu.html", method = RequestMethod.GET)
	public String menu(Model model, HttpServletRequest request) {

		if (loginService.sessionCheck(request)) {
			// セッション情報が不正の場合
			return View.LOGIN.getName();
		}

		return View.MENU.getName();
	}

}
