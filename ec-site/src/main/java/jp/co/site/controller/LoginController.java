package jp.co.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;

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
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		session.removeAttribute(EcSiteSessionKey.CUSTOMER_ID.getName());
		return View.LOGIN.getName();
	}

}
