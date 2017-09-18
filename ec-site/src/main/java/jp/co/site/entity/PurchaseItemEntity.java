package jp.co.site.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class PurchaseItemEntity implements Serializable {

	@Setter
	@Getter
	@Column(name = "SEQ_CUSTOMER_ID")
	private String customerId;

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
	@Column(name = "REG_DATE")
	private Date regDate;

}
