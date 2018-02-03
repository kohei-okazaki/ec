package jp.co.ec.site.service;

import jp.co.ec.common.dto.LoginUserDto;

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
	public LoginUserDto findLoginUserByCustomerId(String customerId);
}
