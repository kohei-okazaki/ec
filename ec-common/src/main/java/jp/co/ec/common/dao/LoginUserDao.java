package jp.co.ec.common.dao;

import java.util.List;

import jp.co.ec.common.dto.LoginUserDto;

/**
 * @author kou1210hei<br>
 * ログインユーザのdao<br>
 *
 */
public interface LoginUserDao {

	/**
	 * 指定されたパスワードからログインユーザ作成する<br>
	 * @param password
	 * @return ログインユーザ情報
	 */
	void createLoginUser(String password);

	/**
	 * ログインユーザを更新する<br>
	 * @param dto
	 */
	void updateLoginUser(LoginUserDto dto);

	/**
	 * ログインユーザを全部検索する<br>
	 * @return ログインユーザ情報
	 */
	List<LoginUserDto> findLoginUser();

	/**
	 * 顧客IDからログインユーザを検索する<br>
	 * @param customerId
	 * @return ログインユーザ情報
	 */
	LoginUserDto findLoginUserByCustomerId(String customerId);

}
