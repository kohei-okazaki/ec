package jp.co.site.entity;

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
 * ログインユーザのEntityクラス<br>
 *
 */
@Entity
@Table(name = "LOGIN_USER")
@ToString(exclude = "password")
public class LoginUserEntity implements Serializable {

	@Id
	@Setter
	@Getter
	@Column(name = "SEQ_CUSTOMER_ID")
	private String customerId;

	@Setter
	@Getter
	@Column(name = "PASSWORD")
	private String password;

	@Setter
	@Getter
	@Column(name = "REG_DATE")
	private Date regDate;
}
