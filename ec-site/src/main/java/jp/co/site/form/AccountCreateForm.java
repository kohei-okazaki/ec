package jp.co.site.form;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * アカウント作成フォームクラス<br>
 *
 */
public class AccountCreateForm {

	@Setter
	@Getter
	private String password;

	@Setter
	@Getter
	private String confirmPassword;

}
