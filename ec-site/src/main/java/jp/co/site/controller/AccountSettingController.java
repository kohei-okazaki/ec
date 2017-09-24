package jp.co.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.site.entity.LoginUserEntity;
import jp.co.site.service.AccountSearchService;
import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;

/**
 * @author kou1210hei<br>
 * アカウント設定コントローラクラス<br>
 *
 */
@Controller
public class AccountSettingController {

	/** ログインユーザ検索サービス */
	@Autowired
	private AccountSearchService accountSearchService;

	/**
	 * アカウント設定画面<br>
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "account-setting.html", method = RequestMethod.GET)
	public String accountSetting(Model model, HttpServletRequest request) {

		// セッションから顧客IDを取得
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute(EcSiteSessionKey.SEQ_CUSTOMER_ID.getName());

		LoginUserEntity entity = accountSearchService.findLoginUserByCustomerId(customerId);
		model.addAttribute("loginUser", entity);





		return View.ACCOUNTSETTING.getName();
	}
}
