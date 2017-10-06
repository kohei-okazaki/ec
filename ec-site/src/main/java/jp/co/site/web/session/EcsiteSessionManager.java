package jp.co.site.web.session;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import jp.co.site.util.StringUtil;

/**
 * @author kou1210hei<br>
 * ECサイトのsession管理クラス<br>
 *
 */
public class EcsiteSessionManager {

	private static EcsiteSessionManager instance = new EcsiteSessionManager();

	public static EcsiteSessionManager getInstance() {
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
