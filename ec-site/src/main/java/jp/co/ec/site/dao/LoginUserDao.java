package jp.co.ec.site.dao;

import java.util.List;

import jp.co.ec.site.dto.LoginUserDto;


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
	public LoginUserDto createLoginUser(String password);

	/**
	 * ログインユーザを更新する<br>
	 * @param dto
	 */
	public void updateLoginUser(LoginUserDto dto);

	/**
	 * ログインユーザを全部検索する<br>
	 * @return ログインユーザ情報
	 */
	public List<LoginUserDto> getAllDate();

	/**
	 * 顧客IDからログインユーザを検索する<br>
	 * @param customerId
	 * @return ログインユーザ情報
	 */
	public LoginUserDto getLoginUserByCustomerId(String customerId);

}
