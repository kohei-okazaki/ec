package jp.co.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.site.dto.LoginUserDto;
import jp.co.site.form.AccountCreateForm;
import jp.co.site.log.EcSiteLogger;
import jp.co.site.service.AccountCreateService;
import jp.co.site.view.PageView;
import jp.co.site.view.View;

/**
 * @author kou1210hei<br>
 * アカウント作成コントローラ<br>
 *
 */
@Controller
public class AccountCreateController {

	/** アカウント作成サービス */
	@Autowired
	private AccountCreateService accountCreateService;

	/**
	 * アカウント作成画面<br>
	 * @param model
	 * @return アカウント作成画面
	 */
	@RequestMapping(value = "/account-create.html", method = RequestMethod.GET)
	public String accountCreate(Model model) {

		EcSiteLogger.getInstance().info(this.getClass(), " # accountCreate");

		model.addAttribute("page", PageView.INPUT.getName());

		return View.ACCOUNT_CREATE.getName();
	}

	/**
	 * 確認画面<br>
	 * @param model
	 * @param form
	 * @return 確認画面
	 */
	@RequestMapping(value = "/account-create-confirm.html", method = RequestMethod.POST)
	public String confirm(Model model, AccountCreateForm form) {

		EcSiteLogger.getInstance().info(this.getClass(), " # confirm");

		if (accountCreateService.invalidPassword(form)) {
			EcSiteLogger.getInstance().error(this.getClass(), "パスワードの入力が不正です。");
			// パスワードの入力が不正の場合
			model.addAttribute("page", PageView.INPUT.getName());
			return View.ACCOUNT_CREATE.getName();
		}

		model.addAttribute("password", form.getPassword());
		model.addAttribute("page", PageView.CONFIRM.getName());

		return View.ACCOUNT_CREATE.getName();
	}

	/**
	 * 完了画面<br>
	 * @param model
	 * @param form
	 * @return 完了画面
	 */
	@RequestMapping(value = "/account-create-complete.html", method = RequestMethod.POST)
	public String complete(Model model, AccountCreateForm form) {

		EcSiteLogger.getInstance().info(this.getClass(), " # complete");

		LoginUserDto loginUserDto = accountCreateService.createLoginUser(form);
		model.addAttribute("customerId", loginUserDto.getSeqCustomerId());
		model.addAttribute("password", loginUserDto.getPassword());
		model.addAttribute("page", PageView.COMPLETE.getName());

		return View.ACCOUNT_CREATE.getName();
	}

}
