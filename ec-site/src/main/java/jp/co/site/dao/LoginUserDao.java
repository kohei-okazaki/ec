package jp.co.site.dao;

import java.util.List;

import jp.co.site.entity.LoginUserEntity;

/**
 * @author kou1210hei<br>
 * ログインユーザのdao<br>
 *
 */
public interface LoginUserDao {

	public LoginUserEntity createLoginUser(String password);

	public void updateLoginUser(LoginUserEntity entity);

	public List<LoginUserEntity> getAllDate();

	public LoginUserEntity getLoginUserEntityByCustomerId(String customerId);

}
