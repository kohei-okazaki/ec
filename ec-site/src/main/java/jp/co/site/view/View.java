package jp.co.site.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * 遷移先のview<br>
 */
public enum View {

	LOGIN("login"),
	ACCOUNT_CREATE("account-create"),
	MENU("menu"),
	PURCHASE("purchase"),
	HISTORY("history");

	@Setter(value = AccessLevel.PRIVATE)
	@Getter
	private String name;

	private View(String name) {
		setName(name);
	}
}
