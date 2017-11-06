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
 * ログインユーザのEntityクラス<br>
 *
 */
@Entity
@Table(name = "LOGIN_USER")
@ToString(exclude = "password")
public class LoginUserDto implements Serializable {

	@Id
	@Setter
	@Getter
	@Column(name = "SEQ_CUSTOMER_ID")
	private String seqCustomerId;

	@Setter
	@Getter
	@Column(name = "PASSWORD")
	private String password;

	@Setter
	@Getter
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Setter
	@Getter
	@Column(name = "REG_DATE")
	private Date regDate;
}
