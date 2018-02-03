package jp.co.ec.common.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.ec.common.dao.LoginUserDao;
import jp.co.ec.common.dto.LoginUserDto;

/**
 * @author kou1210hei<br>
 * ログインユーザDao実装クラス<br>
 *
 */
@Repository
public class LoginUserDaoImpl implements LoginUserDao {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createLoginUser(LoginUserDto dto) {
		// FIXME
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateLoginUser(LoginUserDto dto) {
		// FIXME
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<LoginUserDto> findLoginUser() {
		// FIXME
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
	 * {@inheritDoc}
	 */
	@Override
	public LoginUserDto findLoginUserByCustomerId(String customerId) {
		// FIXME
		LoginUserDto dto = new LoginUserDto();
		dto.setSeqCustomerId(customerId);
		dto.setPassword("password");
		dto.setRegDate(new Date());
		return dto;
	}

}
