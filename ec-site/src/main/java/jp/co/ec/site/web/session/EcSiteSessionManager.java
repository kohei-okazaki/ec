package jp.co.ec.site.web.session;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import jp.co.ec.common.util.StringUtil;

public class EcSiteSessionManager {

	private static EcSiteSessionManager instance = new EcSiteSessionManager();

	// インスタンス生成を制限
	private EcSiteSessionManager() {
	}

	public static EcSiteSessionManager getInstance() {
		return instance;
	}

	/**
	 * sessionにセットする<br>
	 * @param session
	 * @param key
	 * @param value
	 */
	public void setAttribute(HttpSession session, EcSiteSessionKey key, String value) {
		session.setAttribute(key.getName(), value);
	}

	/**
	 * sessionから指定されたキーに対応するvalueを返す<br>
	 * valueがnullの場合、"null"を返す
	 * @param session
	 * @param key
	 * @return value
	 */
	public String getAttribute(HttpSession session, EcSiteSessionKey key) {

		Object value = session.getAttribute(key.getName());
		return Objects.isNull(value) ? StringUtil.EMPTY : value.toString();
	}

	/**
	 * sessionからキーに対応するレコードを削除する<br>
	 * @param session
	 * @param key
	 */
	public void removeKey(HttpSession session, EcSiteSessionKey key) {
		session.removeAttribute(key.getName());
	}
}
