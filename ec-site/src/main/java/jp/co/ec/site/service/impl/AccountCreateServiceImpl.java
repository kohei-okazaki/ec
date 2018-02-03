package jp.co.ec.site.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ec.common.dao.LoginUserDao;
import jp.co.ec.common.dto.LoginUserDto;
import jp.co.ec.common.util.StringUtil;
import jp.co.ec.site.form.AccountCreateForm;
import jp.co.ec.site.service.AccountCreateService;

@Service
public class AccountCreateServiceImpl implements AccountCreateService {

	/** ログインユーザDao */
	@Autowired
	private LoginUserDao dao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean invalidPassword(AccountCreateForm form) {

		StringUtil.isEquals(form.getPassword(), form.getConfirmPassword());
		if (StringUtil.isEmpty(form.getPassword()) || StringUtil.isEmpty(form.getConfirmPassword())) {
			return true;
		}
		return !StringUtil.isEquals(form.getPassword(), form.getConfirmPassword());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createLoginUser(LoginUserDto dto) {
		this.dao.createLoginUser(dto);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LoginUserDto toLoginUserDto(AccountCreateForm form) {

		LoginUserDto dto = new LoginUserDto();
		dto.setPassword(form.getPassword());
		dto.setRegDate(new Date());

		return dto;
	}

}
