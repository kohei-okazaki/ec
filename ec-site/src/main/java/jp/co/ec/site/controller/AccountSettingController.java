package jp.co.ec.site.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ec.common.dto.DeliveryInfoDto;
import jp.co.ec.common.dto.LoginUserDto;
import jp.co.ec.common.util.DateUtil;
import jp.co.ec.site.form.AccountSettingForm;
import jp.co.ec.site.log.EcSiteLogger;
import jp.co.ec.site.service.AccountSearchService;
import jp.co.ec.site.service.AccountSettingService;
import jp.co.ec.site.service.DeliveryInfoSearchService;
import jp.co.ec.site.web.session.EcSiteSessionKey;
import jp.co.ec.site.web.session.EcSiteSessionManager;
import jp.co.ec.site.web.view.PageView;
import jp.co.ec.site.web.view.View;

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

		EcSiteLogger.getInstance().info(this.getClass(), " # accountSetting");

		// sessionから顧客IDを取得
		HttpSession session = request.getSession();
		String seqCustomerId = EcSiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);

		// ログインユーザ情報を取得
		LoginUserDto loginUserDto = accountSearchService.findLoginUserByCustomerId(seqCustomerId);
		model.addAttribute("loginUser", loginUserDto);

		// 配送先情報を取得
		DeliveryInfoDto deliveryInfoDto = deliveryInfoSearchService.findDeliveryInfoByCustomerId(seqCustomerId);
		model.addAttribute("deliveryInfo", deliveryInfoDto);

		model.addAttribute("regDate", DateUtil.getConvertDate(deliveryInfoDto.getRegDate()));

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

		EcSiteLogger.getInstance().info(this.getClass(), " # accountSettingInput");

		// セッションから顧客IDを取得
		HttpSession session = request.getSession();
		String customerId = EcSiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);

		// ログインユーザ情報を取得
		LoginUserDto loginUserDto = accountSearchService.findLoginUserByCustomerId(customerId);
		model.addAttribute("loginUser", loginUserDto);

		// 配送先情報を取得
		DeliveryInfoDto deliveryInfoDto = deliveryInfoSearchService.findDeliveryInfoByCustomerId(customerId);
		model.addAttribute("deliveryInfo", deliveryInfoDto);

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

		EcSiteLogger.getInstance().info(this.getClass(), " # accountsettingconfirm");

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
