package jp.co.ec.common.log;

/**
 * @author kou1210hei<br>
 * LOG基底クラス<br>
 *
 */
public abstract class BaseLogger {

	/**
	 * infologを出力
	 * @param clazz
	 */
	protected abstract void info(Class<?> clazz);

	/**
	 * debuglogを出力
	 * @param clazz
	 */
	protected abstract void debug(Class<?> clazz);

	/**
	 * errorlogを出力
	 * @param clazz
	 */
	protected abstract void error(Class<?> clazz);

	/**
	 * warnlogを出力
	 * @param clazz
	 */
	protected abstract void warn(Class<?> clazz);


	/**
	 * infologを出力
	 * @param clazz
	 * @param message
	 */
	protected abstract void info(Class<?> clazz, String message);

	/**
	 * debuglogを出力
	 * @param clazz
	 * @param message
	 */
	protected abstract void debug(Class<?> clazz, String message);

	/**
	 * errorlogを出力
	 * @param clazz
	 * @param message
	 */
	protected abstract void error(Class<?> clazz, String message);

	/**
	 * warnlogを出力
	 * @param clazz
	 * @param message
	 */
	protected abstract void warn(Class<?> clazz, String message);

}
