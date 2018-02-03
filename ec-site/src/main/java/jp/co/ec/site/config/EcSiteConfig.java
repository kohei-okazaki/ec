package jp.co.ec.site.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.co.ec.common.dao.DeliveryInfoDao;
import jp.co.ec.common.dao.LoginUserDao;
import jp.co.ec.common.dao.PurchaseDao;
import jp.co.ec.common.dao.impl.DeliveryInfoDaoImpl;
import jp.co.ec.common.dao.impl.LoginUserDaoImpl;
import jp.co.ec.common.dao.impl.PurchaseDaoImpl;

@Configuration
public class EcSiteConfig {

	/**
	 * ログインユーザDaoBean
	 * @return
	 */
	@Bean
	public LoginUserDao LoginUserDao() {
		return new LoginUserDaoImpl();
	}

	/**
	 * 購入商品DaoBean
	 * @return
	 */
	@Bean
	public PurchaseDao purchaseDao() {
		return new PurchaseDaoImpl();
	}

	/**
	 * 配送先情報DaoBean
	 * @return
	 */
	@Bean
	public DeliveryInfoDao deliveryInfoDao() {
		return new DeliveryInfoDaoImpl();
	}

}
