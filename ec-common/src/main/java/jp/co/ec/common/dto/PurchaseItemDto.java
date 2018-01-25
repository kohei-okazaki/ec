package jp.co.ec.common.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author kou1210hei<br>
 * 購入商品情報のEntityクラス<br>
 *
 */
@Entity
@ToString
@Table(name = "PURCHASE_ITEM_INFO")
public class PurchaseItemDto implements Serializable {

	@Id
	@Setter
	@Getter
	@Column(name = "SEQ_ITEM_ID")
	private String seqItemId;

	@Setter
	@Getter
	@Column(name = "SEQ_CUSTOMER_ID")
	private String seqCustomerId;

	@Setter
	@Getter
	@Column(name = "ITEM_NAME")
	private String itemName;

	@Setter
	@Getter
	@Column(name = "ITEM_COUNT")
	private Integer itemCount;

	@Setter
	@Getter
	@Column(name = "ITEM_PRICE")
	private Integer itemPrice;

	@Setter
	@Getter
	@Column(name = "PAYMENT_METHOD")
	private String paymentMethod;

	@Setter
	@Getter
	@Column(name = "PAYMENT_COUNT")
	private Integer paymentCount;

	@Setter
	@Getter
	@Column(name = "BUY_DATE")
	private Date buyDate;

	@Setter
	@Getter
	@Column(name = "REG_DATE")
	private Date regDate;

}
