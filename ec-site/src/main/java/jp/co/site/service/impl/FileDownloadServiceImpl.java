package jp.co.site.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.site.entity.PurchaseItemEntity;
import jp.co.site.excel.HistoryExcelBuilder;
import jp.co.site.service.FileDownloadService;

/**
 * @author kou1210hei<br>
 * ファイルダウンロードサービス実装クラス<br>
 *
 */
@Service
public class FileDownloadServiceImpl implements FileDownloadService {

	/**
	 * 実行処理
	 * @return
	 */
	@Override
	public View execute(List<PurchaseItemEntity> list) {
		return new HistoryExcelBuilder(list);
	}

}
