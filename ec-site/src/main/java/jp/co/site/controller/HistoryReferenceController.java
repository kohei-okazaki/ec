package jp.co.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.site.entity.PurchaseItemEntity;
import jp.co.site.service.FileDownloadService;
import jp.co.site.service.PurchaseSearchService;
import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;

/**
 * @author kou1210hei<br>
 * 購入商品履歴コントローラ
 *
 */
@Controller
public class HistoryReferenceController {

	/** 購入履歴サービス */
	@Autowired
	private PurchaseSearchService purchaseSearchService;
	/** ファイルダウンロードサービス */
	@Autowired
	private FileDownloadService downloadService;

	@RequestMapping(value = "/history.html")
	public String reference(Model model, HttpServletRequest request) {

		// 顧客IDを取得
		String customerId = (String) request.getSession().getAttribute(EcSiteSessionKey.SEQ_CUSTOMER_ID.getName());
		List<PurchaseItemEntity> resultList = purchaseSearchService.getPurchaseEntityByCustomerId(customerId);

		model.addAttribute("resultList", resultList);

		return View.HISTORY.getName();
	}

	@RequestMapping(value = "/history.html", method = RequestMethod.POST)
	public ModelAndView excelDownload(Model model, HttpServletRequest request) {

		// 顧客IDを取得
		String customerId = (String) request.getSession().getAttribute(EcSiteSessionKey.SEQ_CUSTOMER_ID.getName());
		List<PurchaseItemEntity> resultList = purchaseSearchService.getPurchaseEntityByCustomerId(customerId);

		return new ModelAndView(downloadService.execute(resultList));
	}





}
