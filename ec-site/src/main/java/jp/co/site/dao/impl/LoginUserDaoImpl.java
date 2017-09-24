package jp.co.site.dao.impl;

import java.util.ArrayList;
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

	/**
	 * ログインユーザ作成する<br>
	 * @param password
	 * @return
	 */
	@Override
	public LoginUserEntity createLoginUser(String password) {
		LoginUserEntity entity = new LoginUserEntity();
		entity.setSeqCustomerId("master");
		entity.setPassword(password);
		entity.setRegDate(new Date());
		return entity;
	}

	/**
	 * ログインユーザを更新する<br>
	 * @param entity
	 */
	@Override
	public void updateLoginUser(LoginUserEntity entity) {

	}

	/**
	 * ログインユーザを全部検索する<br>
	 * @return 検索結果
	 */
	@Override
	public List<LoginUserEntity> getAllDate() {
		List<LoginUserEntity> resultList = new ArrayList<LoginUserEntity>();
		for (int i = 0; i < 15; i++) {
			LoginUserEntity entity = new LoginUserEntity();
			if (i % 3 == 0) {
				entity.setSeqCustomerId("test001");
				entity.setPassword("pass1");
				entity.setRegDate(new Date());
			} else if (i % 4 == 0) {
				entity.setSeqCustomerId("test002");
				entity.setPassword("pass2");
				entity.setRegDate(new Date());
			} else if (i % 7 == 0) {
				entity.setSeqCustomerId("test003");
				entity.setPassword("pass3");
				entity.setRegDate(new Date());
			}
			resultList.add(entity);
		}
		return resultList;
	}

	/**
	 * 顧客IDからログインユーザを検索する<br>
	 * @param customerId
	 * @return
	 */
	@Override
	public LoginUserEntity getLoginUserEntityByCustomerId(String customerId) {
		// FIXME
		LoginUserEntity entity = new LoginUserEntity();
		entity.setSeqCustomerId(customerId);
		entity.setPassword("password");
		entity.setRegDate(new Date());
		return entity;
	}

}
