package jp.co.site.util;

import jp.co.site.other.Property;

/**
 * @author kohei.okazaki<br>
 * PropertyアノテーションのUtilクラス
 *
 */
public class PropertyUtil {

	/**
	 * インスタンス生成を制限
	 */
	private PropertyUtil() {
	}

	/**
	 * Propertyアノテーションのvalueを返す<br>
	 * @param clazz
	 * @return value
	 */
	public static String getValue(Class<?> clazz) {
		return getPropertyClass(clazz).value();
	}

	/**
	 * Propertyアノテーションのクラス型を取得する<br>
	 * @param clazz
	 * @return
	 */
	private static Property getPropertyClass(Class<?> clazz) {
		return clazz.getAnnotation(Property.class);
	}

}
