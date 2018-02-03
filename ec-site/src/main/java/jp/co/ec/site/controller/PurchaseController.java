package jp.co.ec.site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.ec.common.dto.PurchaseItemDto;
import jp.co.ec.site.form.PurchaseForm;
import jp.co.ec.site.log.EcSiteLogger;
import jp.co.ec.site.service.PurchaseService;
import jp.co.ec.site.web.view.PageView;
import jp.co.ec.site.web.view.View;

/**
 * @author kou1210hei<br>
 * 購入画面コントローラ<br>
 *
 */
@Controller
public class PurchaseController {

	/** 購入商品サービス */
	@Autowired
	private PurchaseService purchaseService;

	/**
	 * 購入画面
	 * @param model
	 * @return 購入画面
	 */
	@RequestMapping(value = "/purchase.html", method = RequestMethod.GET)
	public String purchase(Model model) {

		EcSiteLogger.getInstance().info(this.getClass(), " # purchase");

		model.addAttribute("page", PageView.INPUT.getName());

		return View.PURCHASE.getName();
	}

	/**
	 * 購入確認画面
	 * @param model
	 * @param form
	 * @return 確認画面
	 */
	@RequestMapping(value = "/purchase-confirm.html", method = RequestMethod.POST)
	public String confirm(Model model, PurchaseForm form) {

		EcSiteLogger.getInstance().info(this.getClass(), " # confirm");

		if (purchaseService.checkPurchaseItem(form)) {
			// 購入商品情報が不正であった場合
			model.addAttribute("page", PageView.INPUT.getName());
			return View.PURCHASE.getName();
		}

		model.addAttribute("itemName", form.getItemName());
		model.addAttribute("itemCount", form.getItemCount());
		model.addAttribute("itemPrice", form.getItemPrice());
		model.addAttribute("paymentMethod", form.getPaymentMethod());
		model.addAttribute("paymentCount", form.getPaymentCount());

		model.addAttribute("page", PageView.CONFIRM.getName());

		return View.PURCHASE.getName();
	}

	/**
	 * 購入完了画面
	 * @param model
	 * @param form
	 * @return 完了画面
	 */
	@RequestMapping(value = "/purchase-complete.html", method = RequestMethod.POST)
	public String complete(Model model, PurchaseForm form) {

		EcSiteLogger.getInstance().info(this.getClass(), " # complete");

		PurchaseItemDto dto = new PurchaseItemDto();
		dto.setItemName(form.getItemName());
		dto.setItemPrice(form.getItemPrice());
		dto.setItemCount(form.getItemCount());
		dto.setPaymentMethod(form.getPaymentMethod());
		dto.setPaymentCount(form.getPaymentCount());
		// 購入商品情報を登録する
		purchaseService.registPurchaseItem(dto);

		model.addAttribute("itemName", form.getItemName());
		model.addAttribute("itemCount", form.getItemCount());
		model.addAttribute("itemPrice", form.getItemPrice());
		model.addAttribute("paymentMethod", form.getPaymentMethod());
		model.addAttribute("paymentCount", form.getPaymentCount());

		model.addAttribute("page", PageView.COMPLETE.getName());

		return View.PURCHASE.getName();
	}

}
