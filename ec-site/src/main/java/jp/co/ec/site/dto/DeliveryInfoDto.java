package jp.co.ec.site.dto;

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
 * 配送先情報のEntityクラス<br>
 *
 */
@Entity
@ToString
@Table(name = "DELIVERY_IMFO")
public class DeliveryInfoDto implements Serializable {

	@Id
	@Setter
	@Getter
	@Column(name = "SEQ_CUSTOMER_ID")
	private String seqCustomerId;

	@Setter
	@Getter
	@Column(name = "PREFECTURES")
	private String prefectures;

	@Setter
	@Getter
	@Column(name = "CITY")
	private String city;

	@Setter
	@Getter
	@Column(name = "ADDRESS")
	private String address;

	@Setter
	@Getter
	@Column(name = "REG_DATE")
	private Date regDate;

}
