package jp.co.common.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	/**
	 * 取得したlocaleの時間から書式を整えた時間を返却
	 * @param locale
	 * @return
	 */
	public static String getFormattedTime(Locale locale) {

		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		return format.format(new Date()).replaceAll(" JST", StringUtil.TEMP).trim();
	}

	public static String getSystemDate() {
		DateFormat format = DateFormat.getTimeInstance();
		return format.format(new Date());
	}

}
