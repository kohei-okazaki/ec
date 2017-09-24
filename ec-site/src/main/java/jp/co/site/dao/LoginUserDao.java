package jp.co.site.dao;

import java.util.List;

import jp.co.site.entity.LoginUserEntity;

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
	public LoginUserEntity createLoginUser(String password);

	/**
	 * ログインユーザを更新する<br>
	 * @param entity
	 */
	public void updateLoginUser(LoginUserEntity entity);

	/**
	 * ログインユーザを全部検索する<br>
	 * @return ログインユーザ情報
	 */
	public List<LoginUserEntity> getAllDate();

	/**
	 * 顧客IDからログインユーザを検索する<br>
	 * @param customerId
	 * @return ログインユーザ情報
	 */
	public LoginUserEntity getLoginUserByCustomerId(String customerId);

}
