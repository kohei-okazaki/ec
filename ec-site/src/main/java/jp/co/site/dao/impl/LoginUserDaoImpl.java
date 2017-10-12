package jp.co.site.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.site.dao.LoginUserDao;
import jp.co.site.dto.LoginUserDto;

/**
 * @author kou1210hei<br>
 * ログインユーザのdao実装クラス<br>
 *
 */
@Repository
public class LoginUserDaoImpl implements LoginUserDao {

	/**
	 * 指定されたパスワードからログインユーザ作成する<br>
	 * @param password
	 * @return ログインユーザ情報
	 */
	@Override
	public LoginUserDto createLoginUser(String password) {
		LoginUserDto dto = new LoginUserDto();
		dto.setSeqCustomerId("master");
		dto.setPassword(password);
		dto.setRegDate(new Date());
		return dto;
	}

	/**
	 * ログインユーザを更新する<br>
	 * @param dto
	 */
	@Override
	public void updateLoginUser(LoginUserDto dto) {
		// TODO 更新処理を追加
	}

	/**
	 * ログインユーザを全部検索する<br>
	 * @return 検索結果
	 */
	@Override
	public List<LoginUserDto> getAllDate() {
		List<LoginUserDto> resultList = new ArrayList<LoginUserDto>();
		for (int i = 0; i < 15; i++) {
			LoginUserDto dto = new LoginUserDto();
			if (i % 3 == 0) {
				dto.setSeqCustomerId("test001");
				dto.setPassword("pass1");
				dto.setRegDate(new Date());
			} else if (i % 4 == 0) {
				dto.setSeqCustomerId("test002");
				dto.setPassword("pass2");
				dto.setRegDate(new Date());
			} else if (i % 7 == 0) {
				dto.setSeqCustomerId("test003");
				dto.setPassword("pass3");
				dto.setRegDate(new Date());
			}
			resultList.add(dto);
		}
		return resultList;
	}

	/**
	 * 顧客IDからログインユーザを検索する<br>
	 * @param customerId
	 * @return ログインユーザ情報
	 */
	@Override
	public LoginUserDto getLoginUserByCustomerId(String customerId) {
		// FIXME
		LoginUserDto dto = new LoginUserDto();
		dto.setSeqCustomerId(customerId);
		dto.setPassword("password");
		dto.setRegDate(new Date());
		return dto;
	}

}
