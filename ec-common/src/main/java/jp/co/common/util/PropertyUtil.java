package jp.co.common.util;

import jp.co.common.other.Property;

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
	 * @return
	 */
	public static String getValue(Class<?> clazz) {
		Property property = (Property) clazz.getAnnotation(Property.class);
		return property.value();
	}

}
