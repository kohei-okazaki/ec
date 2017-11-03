package jp.co.ec.common.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kohei.okazaki<br>
 * Excelのアノテーションクラス<br>
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE })
public @interface Excel {

	/**
	 * シート名
	 * @return sheetName
	 */
	String sheetName();

	/**
	 * セル名
	 * @return cellName
	 */
	String[] cellNames();

}
