package jp.co.site.service;

import java.util.List;

import org.springframework.web.servlet.View;

import jp.co.site.entity.PurchaseItemEntity;

/**
 * @author kou1210hei<br>
 * ファイルダウンロードサービスIF
 *
 */
public interface FileDownloadService {

	/**
	 * 実行処理
	 * @param list
	 * @return view
	 */
	public View execute(List<PurchaseItemEntity> list);
}
