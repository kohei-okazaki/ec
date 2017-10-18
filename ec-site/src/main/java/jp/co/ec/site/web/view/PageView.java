package jp.co.ec.site.web.view;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * ページView<br>
 *
 */
public enum PageView {

	INPUT("0"),
	CONFIRM("1"),
	COMPLETE("2"),
	DETAIL("3");

	@Setter(value = AccessLevel.PRIVATE)
	@Getter
	private String name;

	private PageView(String name) {
		setName(name);
	}
}
