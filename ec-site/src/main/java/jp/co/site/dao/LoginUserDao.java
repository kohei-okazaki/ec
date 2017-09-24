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
	 * @return
	 */
	public LoginUserEntity createLoginUser(String password);

	/**
	 * ログインユーザを更新する<br>
	 * @param entity
	 */
	public void updateLoginUser(LoginUserEntity entity);

	/**
	 * ログインユーザを全部検索する<br>
	 * @return
	 */
	public List<LoginUserEntity> getAllDate();

	/**
	 * 顧客IDからログインユーザを検索する<br>
	 * @param customerId
	 * @return
	 */
	public LoginUserEntity getLoginUserEntityByCustomerId(String customerId);

}
