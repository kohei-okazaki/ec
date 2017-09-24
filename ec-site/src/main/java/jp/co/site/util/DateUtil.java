package jp.co.site.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author kou1210hei<br>
 * DateのUtilクラス<br>
 *
 */
public class DateUtil {

	/**
	 * 取得したlocaleの時間から書式を整えた時間を返却
	 * @param locale
	 * @return 成形させた日付
	 */
	public static String getFormattedTime(Locale locale) {

		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		return format.format(new Date()).replaceAll(" JST", StringUtil.TEMP).trim();
	}

	/**
	 * 指定されたDateの書式を整えた日付を返す<br>
	 * @param date
	 * @return
	 */
	public static String getFormattedDate(Date date) {
		DateFormat format = DateFormat.getTimeInstance();
		return format.format(date);
	}

	public static String getSystemDate() {
		DateFormat format = DateFormat.getTimeInstance();
		return format.format(new Date());
	}

	/**
	 * 日付の比較を行う.<br>
	 * 日付が等しい場合は0<br>
	 * Date1が引数Date2より前の場合は-1<br>
	 * Date1が引数Date2より後の場合は1<br>
	 * を返す.<br>
	 * @param date1
	 * @param date2
	 * @return 判定結果
	 */
	public static String getSubDate(Date date1, Date date2) {
		return String.valueOf(date1.compareTo(date2));
	}

}
