package jp.co.ec.site.form;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * アカウント設定フォームクラス<br>
 *
 */
public class AccountSettingForm {

	@Setter
	@Getter
	private String seqCustomerId;

	@Setter
	@Getter
	private String password;

	@Setter
	@Getter
	private String prefectures;

	@Setter
	@Getter
	private String city;

	@Setter
	@Getter
	private String address;

}
