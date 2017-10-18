package jp.co.ec.site.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;

import jp.co.ec.site.dto.PurchaseItemDto;
import jp.co.ec.site.excel.HistoryExcelBuilder;
import jp.co.ec.site.service.FileDownloadService;

@Service
public class FileDownloadServiceImpl implements FileDownloadService {

	/**
	 * 実行処理
	 * @param list
	 * @return view
	 */
	@Override
	public View execute(List<PurchaseItemDto> list) {
		return new HistoryExcelBuilder(list);
	}
}
