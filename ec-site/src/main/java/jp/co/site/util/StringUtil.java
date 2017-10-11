package jp.co.site.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * @author kou1210hei<br>
 * 文字列のUtilクラス<br>
 *
 */
public class StringUtil {

	public static final String COMMA = ",";
	public static final String HYPHEN = "-";
	public static final String COLON = ":";
	public static final String PERIOD = ".";
	public static final String EMPTY = "";
	public static final String EQUAL = "=";
	public static final String NEW_LINE = "\r\n";

	/**
	 * インスタンス生成を制限
	 */
	private StringUtil() {
	}

	/**
	 * 区切りたい文字列を区切り文字で、区切ったリストを返す<br>
	 * @param target
	 * @param delim
	 * @return result
	 */
	public static List<String> toStrList(String target, String delim) {

		if (Objects.isNull(target) || EMPTY.equals(target)) {
			return null;
		}
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(target, COMMA);

		while (tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken().trim());
		}
		return result;

	}

	/**
	 * 空文字かどうか判定する<br>
	 * @param target
	 * @return 判定結果
	 */
	public static boolean isEmpty(String target) {
		return Objects.isNull(target) || EMPTY.equals(target.trim());
	}

	/**
	 * 渡された文字列の比較を行う<br>
	 * 等しい場合true, そうでなければfalse<br>
	 * @param target1
	 * @param target2
	 * @return 判定結果
	 */
	public static boolean isEquals(String target1, String target2) {
		return target1.equals(target2);
	}

	/**
	 * 指定した文字列が最小・最大値に含まれるかどうか判定<br>
	 * @param target 指定した文字列
	 * @param min 最小値
	 * @param max 最大値
	 * @param isSame <=でチェックしたい場合はtrue, <でチェックしたい場合はfalse
	 * @return 含まれる場合true, 含まれない場合falseを返す
	 */
	public static boolean checkLength(String target, int min, int max, boolean isSame) {
		if (Objects.isNull(target) || min == max) {
			return false;
		}
		if (isSame) {
			return min <= target.length() && target.length() <= max;
		} else {
			return min < target.length() && target.length() < max;
		}
	}

}
