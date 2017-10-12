package jp.co.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.site.dao.LoginUserDao;
import jp.co.site.dto.LoginUserDto;
import jp.co.site.service.AccountSearchService;

/**
 * @author kou1210hei<br>
 * ログインユーザ検索サービス実装クラス<br>
 *
 */
@Service
public class AccountSearchServiceImpl implements AccountSearchService {

	/** ログインユーザDao */
	@Autowired
	private LoginUserDao dao;

	/**
	 * 顧客IDからログインユーザ情報を取得する<br>
	 * @param customerId
	 * @return ログインユーザ情報
	 */
	@Override
	public LoginUserDto findLoginUserByCustomerId(String customerId) {
		return dao.getLoginUserByCustomerId(customerId);
	}


}
