package jp.co.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.site.dto.PurchaseItemDto;
import jp.co.site.log.EcSiteLogger;
import jp.co.site.service.FileDownloadService;
import jp.co.site.service.PurchaseSearchService;
import jp.co.site.view.View;
import jp.co.site.web.session.EcSiteSessionKey;
import jp.co.site.web.session.EcSiteSessionManager;

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

	/**
	 * 参照画面を表示する
	 * @param model
	 * @param request
	 * @return 参照画面
	 */
	@RequestMapping(value = "/history.html")
	public String reference(Model model, HttpServletRequest request) {

		EcSiteLogger.getInstance().info(this.getClass(), " # reference");

		// 顧客IDを取得
		HttpSession session = request.getSession();
		String customerId = EcSiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);
		List<PurchaseItemDto> resultList = purchaseSearchService.findPurchaseEntityByCustomerId(customerId);

		model.addAttribute("resultList", resultList);

		return View.HISTORY.getName();
	}

	/**
	 * Excelダウンロードを行う<br>
	 * @param model
	 * @param request
	 * @return 参照画面
	 */
	@RequestMapping(value = "/history-download.html", method = RequestMethod.GET)
	public ModelAndView excelDownload(Model model, HttpServletRequest request) {

		EcSiteLogger.getInstance().info(this.getClass(), " # excelDownload");

		// 顧客IDを取得
		HttpSession session = request.getSession();
		String customerId = EcSiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);
		List<PurchaseItemDto> resultList = purchaseSearchService.findPurchaseEntityByCustomerId(customerId);

		return new ModelAndView(downloadService.execute(resultList));
	}





}
