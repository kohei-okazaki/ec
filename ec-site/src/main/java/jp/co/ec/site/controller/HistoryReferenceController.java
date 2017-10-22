package jp.co.ec.site.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.ec.site.dto.PurchaseItemDto;
import jp.co.ec.site.log.EcSiteLogger;
import jp.co.ec.site.service.FileDownloadService;
import jp.co.ec.site.service.PurchaseSearchService;
import jp.co.ec.site.web.session.EcSiteSessionKey;
import jp.co.ec.site.web.session.EcSiteSessionManager;
import jp.co.ec.site.web.view.View;

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
		List<PurchaseItemDto> resultList = null;
		try {
			resultList = purchaseSearchService.findPurchaseEntityByCustomerId(customerId);
		} catch (ParseException e) {
			e.printStackTrace();
		}

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
		List<PurchaseItemDto> resultList = null;
		try {
			resultList = purchaseSearchService.findPurchaseEntityByCustomerId(customerId);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new ModelAndView(downloadService.execute(resultList));
	}





}
