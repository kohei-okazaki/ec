package jp.co.site.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author kou1210hei<br>
 * ログインフォームクラス<br>
 *
 */
@ToString(exclude = "password")
public class LoginForm {

	@Setter
	@Getter
	private String customerId;

	@Setter
	@Getter
	private String password;

}
