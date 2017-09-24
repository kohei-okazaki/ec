package jp.co.site.service;

import jp.co.site.entity.LoginUserEntity;

/**
 * @author kou1210hei<br>
 * ログインユーザ検索IF
 *
 */
public interface AccountSearchService {

	/**
	 * 顧客IDからログインユーザ情報を取得する<br>
	 * @param customerId
	 * @return ログインユーザ情報
	 */
	public LoginUserEntity findLoginUserByCustomerId(String customerId);
}
