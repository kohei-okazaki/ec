package jp.co.ec.site.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jp.co.ec.site.form.FilePurchaseForm;
import jp.co.ec.site.log.EcSiteLogger;
import jp.co.ec.site.service.FilePurchaseService;
import jp.co.ec.site.web.view.PageView;
import jp.co.ec.site.web.view.View;


/**
 * @author kou1210hei<br>
 * ファイル一括購入コントローラ<br>
 *
 */
@Controller
public class FilePurchaseController {

	/** ファイル一括購入サービス */
	@Autowired
	private FilePurchaseService filePurchaseService;

	@ModelAttribute
	public FilePurchaseForm getFilePurchaseForm() {
		return filePurchaseService.getFilePurchaseForm();
	}

	/**
	 * ファイル入力
	 * @param model
	 * @return 入力画面
	 */
	@RequestMapping(value = "/purchase-file.html", method = RequestMethod.GET)
	public String fileInput(Model model) {

		EcSiteLogger.getInstance().info(this.getClass(), " # fileInput");

		model.addAttribute("page", PageView.INPUT.getName());

		model.addAttribute("filePurchaseForm", getFilePurchaseForm());

		return View.PURCHASE_FILE.getName();
	}

	/**
	 * ファイル確認<br>
	 * @param model
	 * @param form
	 * @param request
	 * @param file
	 * @return 確認画面
	 */
	@ResponseBody
	@RequestMapping(value = "/purchase-file-confirm.html", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
	public String fileConfirm(Model model
							, FilePurchaseForm form
							, HttpServletRequest request
							, @RequestParam(value = "file", required = true) MultipartFile file) {

		EcSiteLogger.getInstance().info(this.getClass(), " # fileConfirm");

		if (file.isEmpty()) {
			EcSiteLogger.getInstance().warn(this.getClass(), "ファイルが空です");
			return View.PURCHASE_FILE.getName();
		}

		File inputFile = (File) request.getAttribute("file");

		MultipartFile uploadFile = form.getFile();

		model.addAttribute("page", PageView.CONFIRM.getName());

		return View.PURCHASE_FILE.getName();
	}

}
