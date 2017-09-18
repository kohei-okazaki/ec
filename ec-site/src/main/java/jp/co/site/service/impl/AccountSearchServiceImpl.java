package jp.co.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.site.dao.LoginUserDao;
import jp.co.site.entity.LoginUserEntity;
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
	 * @return
	 */
	@Override
	public LoginUserEntity findLoginUser(String customerId) {
		return dao.getLoginUserEntityByCustomerId(customerId);
	}


}
