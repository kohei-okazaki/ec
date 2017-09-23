package jp.co.site.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.site.dao.LoginUserDao;
import jp.co.site.entity.LoginUserEntity;

/**
 * @author kou1210hei<br>
 * ログインユーザのdao実装クラス<br>
 *
 */
@Repository
public class LoginUserDaoImpl implements LoginUserDao {

	@Override
	public LoginUserEntity createLoginUser(String password) {
		LoginUserEntity entity = new LoginUserEntity();
		entity.setSeqCustomerId("master");
		entity.setPassword(password);
		entity.setRegDate(new Date());
		return entity;
	}

	@Override
	public void updateLoginUser(LoginUserEntity entity) {

	}

	@Override
	public List<LoginUserEntity> getAllDate() {
		return null;
	}

	@Override
	public LoginUserEntity getLoginUserEntityByCustomerId(String customerId) {
		// FIXME
		LoginUserEntity entity = new LoginUserEntity();
		entity.setSeqCustomerId(customerId);
		entity.setPassword("password");
		return entity;
	}

}
