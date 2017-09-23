package jp.co.site.web.session;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * ECサイトで管理するセッションキー<br>
 *
 */
public enum EcSiteSessionKey {

	SEQ_CUSTOMER_ID("seqCustomerId"),
	PASSWORD("password");

	@Setter(value = AccessLevel.PRIVATE)
	@Getter
	private String name;

	private EcSiteSessionKey(String name) {
		setName(name);
	}

}
