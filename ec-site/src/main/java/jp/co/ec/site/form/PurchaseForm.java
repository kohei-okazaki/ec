package jp.co.ec.site.form;

import lombok.Data;

@Data
public class PurchaseForm {

	/** 商品名 */
	private String itemName;

	/** 商品価格 */
	private Integer itemPrice;

	/** 購入数 */
	private Integer itemCount;

	/** 支払方法 */
	private String paymentMethod;

	/** 支払回数 */
	private Integer paymentCount;

}
