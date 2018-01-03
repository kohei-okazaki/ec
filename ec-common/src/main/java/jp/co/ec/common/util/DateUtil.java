package jp.co.ec.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

/**
 * @author kou1210hei<br>
 * DateのUtilクラス<br>
 *
 */
public class DateUtil {

	public static String FORMAT_YYMMDDHHMISS = "yyyyMMdd HH:mm:ss";

	/**
	 * インスタンス生成を制限
	 */
	private DateUtil() {
	}

	/**
	 * 取得したlocaleの時間から書式を整えた時間を返却
	 * @param locale
	 * @return 書式を整えた日付
	 */
	public static String getFormattedTime(Locale locale) {

		DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		return format.format(new Date()).replaceAll(" JST", StringUtil.EMPTY).trim();
	}

	/**
	 * 日付の比較を行う.<br>
	 * 日付が等しい場合は0<br>
	 * Date1が引数Date2より前の場合は-1<br>
	 * Date1が引数Date2より後の場合は1<br>
	 * を返す.<br>
	 * @param date1
	 * @param date2
	 * @return 比較結果
	 */
	public static String getSubDate(Date date1, Date date2) {
		return String.valueOf(date1.compareTo(date2));
	}

	/**
	 * 現在の日時を取得する。
	 * @return 現在の日時
	 */
	public static LocalDateTime getSystemDate() {
		return LocalDateTime.now();
	}

	/**
	 * date型の日時をLocalDateTimeに編集する。<br>
	 * @param targetDate
	 * @return 変換した日付
	 */
	public static LocalDateTime getConvertDate(Date targetDate) {
		return LocalDateTime.ofInstant(targetDate.toInstant(), ZoneId.systemDefault());
	}

	/**
	 * 文字列型の日付をDate型に変換する。<br>
	 * 変換する日付のフォーマットは"yyyyMMdd HH:mm:ss"とする<br>
	 * @param targetStrDate
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(String targetStrDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYMMDDHHMISS);
		return sdf.parse(targetStrDate);
	}

}
