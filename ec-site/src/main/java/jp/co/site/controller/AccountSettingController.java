package jp.co.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.site.dao.DeliveryInfoSearchService;
import jp.co.site.entity.DeliveryInfoEntity;
import jp.co.site.entity.LoginUserEntity;
import jp.co.site.form.AccountSettingForm;
import jp.co.site.log.EcLogger;
import jp.co.site.service.AccountSearchService;
import jp.co.site.service.AccountSettingService;
import jp.co.site.util.DateUtil;
import jp.co.site.view.PageView;
import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;
import jp.co.site.web.session.EcsiteSessionManager;

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
	/** 配送先情報検索サービス */
	@Autowired
	private DeliveryInfoSearchService deliveryInfoSearchService;
	/** アカウント設定サービス */
	@Autowired
	private AccountSettingService accountSettingService;

	/**
	 * アカウント設定画面<br>
	 * @param model
	 * @param request
	 * @return 設定画面
	 */
	@RequestMapping(value = "/account-setting.html", method = RequestMethod.GET)
	public String accountSetting(Model model, HttpServletRequest request) {

		EcLogger.getInstance().info(this.getClass(), " # accountSetting");

		// セッションから顧客IDを取得
		HttpSession session = request.getSession();
		String customerId = EcsiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);

		// ログインユーザ情報を取得
		LoginUserEntity loginUserentity = accountSearchService.findLoginUserByCustomerId(customerId);
		model.addAttribute("loginUser", loginUserentity);

		// 配送先情報を取得
		DeliveryInfoEntity deliveryInfoEntity = deliveryInfoSearchService.findDeliveryInfoByCustomerId(customerId);
		model.addAttribute("deliveryInfo", deliveryInfoEntity);

		model.addAttribute("regDate", DateUtil.getConvertDate(deliveryInfoEntity.getRegDate()));

		model.addAttribute("page", PageView.DETAIL.getName());

		return View.ACCOUNT_SETTING.getName();
	}

	/**
	 * アカウント設定入力画面<br>
	 * @param model
	 * @param request
	 * @return 入力画面
	 */
	@RequestMapping(value = "/account-setting-input.html", method = RequestMethod.GET)
	public String input(Model model, HttpServletRequest request) {

		EcLogger.getInstance().info(this.getClass(), " # accountSettingInput");

		// セッションから顧客IDを取得
		HttpSession session = request.getSession();
		String customerId = EcsiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);

		// ログインユーザ情報を取得
		LoginUserEntity loginUserentity = accountSearchService.findLoginUserByCustomerId(customerId);
		model.addAttribute("loginUser", loginUserentity);

		// 配送先情報を取得
		DeliveryInfoEntity deliveryInfoEntity = deliveryInfoSearchService.findDeliveryInfoByCustomerId(customerId);
		model.addAttribute("deliveryInfo", deliveryInfoEntity);

		model.addAttribute("page", PageView.INPUT.getName());

		return View.ACCOUNT_SETTING.getName();
	}

	/**
	 * アカウント設定確認画面<br>
	 * @param model
	 * @param request
	 * @param form
	 * @return 確認画面
	 */
	@RequestMapping(value = "/account-setting-confirm.html", method = RequestMethod.POST)
	public String confirm(Model model, HttpServletRequest request, AccountSettingForm form) {

		EcLogger.getInstance().info(this.getClass(), " # accountsettingconfirm");

		if (accountSettingService.invalidForm(form)) {
			// 入力情報に不正がある
			model.addAttribute("errorMessage", "入力情報が不正です");
			model.addAttribute("page", PageView.INPUT.getName());
			return View.ACCOUNT_SETTING.getName();
		}

		model.addAttribute("page", PageView.CONFIRM.getName());

		return View.ACCOUNT_SETTING.getName();
	}
}
