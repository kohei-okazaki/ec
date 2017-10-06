package jp.co.site.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EcLogger {

	/** singeton */
	private static EcLogger instance = new EcLogger();

	/**
	 * インスタンス取得<br>
	 * @return instance
	 */
	public static EcLogger getInstance() {
		return instance;
	}

	/**
	 * infologを出力
	 * @param clazz
	 */
	public void info(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 */
	public void debug(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 */
	public void error(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 */
	public void warn(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}


	/**
	 * infologを出力
	 * @param clazz
	 * @param message
	 */
	public void info(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 * @param message
	 */
	public void debug(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 * @param message
	 */
	public void error(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 * @param message
	 */
	public void warn(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

}
