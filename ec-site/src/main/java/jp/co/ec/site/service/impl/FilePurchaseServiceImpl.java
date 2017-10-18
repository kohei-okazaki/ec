package jp.co.ec.site.service.impl;

import org.springframework.stereotype.Service;

import jp.co.ec.site.form.FilePurchaseForm;
import jp.co.ec.site.service.FilePurchaseService;

@Service
public class FilePurchaseServiceImpl implements FilePurchaseService {

	@Override
	public FilePurchaseForm getFilePurchaseForm() {
		return new FilePurchaseForm();
	}

}
