package jp.co.site.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * キャラセットenum<br>
 *
 */
public enum Charset {

	MS_932("MS932");

	@Setter(value = AccessLevel.PRIVATE)
	@Getter
	private String name;

	private Charset(String name) {
		setName(name);
	}

}
