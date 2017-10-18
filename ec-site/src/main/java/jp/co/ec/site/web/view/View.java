package jp.co.ec.site.web.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * 遷移先のview<br>
 */
public enum View {

	/** ログイン画面 */
	LOGIN("login"),
	/** アカウント作成画面 */
	ACCOUNT_CREATE("account-create"),
	/** メニュー画面 */
	MENU("menu"),
	/** 購入画面 */
	PURCHASE("purchase"),
	/** 購入履歴画面 */
	HISTORY("history"),
	/** アカウント設定画面 */
	ACCOUNT_SETTING("account-setting"),
	/** 一括購入画面 */
	PURCHASE_FILE("purchase-file");

	@Setter(value = AccessLevel.PRIVATE)
	@Getter
	private String name;

	private View(String name) {
		setName(name);
	}
}
