package jp.co.ec.site.form;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

/**
 * @author kou1210hei<br>
 * ファイル購入フォーム<br>
 *
 */
public class FilePurchaseForm implements Serializable {

	@Setter
	@Getter
	private MultipartFile file;

}
