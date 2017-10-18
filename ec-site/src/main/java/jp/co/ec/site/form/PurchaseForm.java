package jp.co.ec.site.form;

import lombok.Data;

@Data
public class PurchaseForm {

	private String itemName;

	private Integer itemPrice;

	private Integer itemCount;

	private String paymentMethod;

	private Integer paymentCount;

}
