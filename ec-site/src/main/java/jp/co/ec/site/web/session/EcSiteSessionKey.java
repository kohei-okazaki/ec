package jp.co.ec.site.web.session;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

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
