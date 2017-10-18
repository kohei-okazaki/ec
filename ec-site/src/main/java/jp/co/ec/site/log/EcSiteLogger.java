package jp.co.ec.site.log;

import jp.co.ec.common.log.BaseLogger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EcSiteLogger extends BaseLogger {

	/** singleton */
	private static EcSiteLogger instance = new EcSiteLogger();

	/**
	 * インスタンス取得<br>
	 * @return instance
	 */
	public static EcSiteLogger getInstance() {
		return instance;
	}

	/**
	 * infologを出力
	 * @param clazz
	 */
	@Override
	public void info(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 */
	@Override
	public void debug(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 */
	@Override
	public void error(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 */
	@Override
	public void warn(Class<?> clazz) {
		log.info("実行 -----> " + clazz.getSimpleName());
	}


	/**
	 * infologを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void info(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * debuglogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void debug(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * errorlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void error(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

	/**
	 * warnlogを出力
	 * @param clazz
	 * @param message
	 */
	@Override
	public void warn(Class<?> clazz, String message) {
		log.info("実行 -----> " + clazz.getSimpleName(), message);
	}

}
