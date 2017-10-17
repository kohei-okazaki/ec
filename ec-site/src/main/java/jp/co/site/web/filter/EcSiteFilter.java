package jp.co.site.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jp.co.common.filter.BaseFilter;
import jp.co.common.util.DateUtil;
import jp.co.site.web.session.EcSiteSessionKey;
import jp.co.site.web.session.EcSiteSessionManager;

/**
 * @author kou1210hei<br>
 * フィルタークラス
 *
 */
@WebFilter
public class EcSiteFilter extends BaseFilter {

	/**
	 * 初期化処理を行う。<br>
	 * このメソッドはアプリケーション起動時に呼び出される。</br>
	 * サーブレットフィルタの初期化パラメータは引数のFilterConfigから取得できる。
	 * @param filterConfig
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		System.out.println("【Filter】 " + this.getClass().getSimpleName() + " start");
	}

	/**
	 * ここに前処理を実装する<br>
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		System.out.println(request.getRequestURI() + " : " + DateUtil.getSystemDate());

		HttpSession session = request.getSession();
		String customerId = EcSiteSessionManager.getInstance().getAttribute(session, EcSiteSessionKey.SEQ_CUSTOMER_ID);
		System.out.println("customerId : " + customerId);
		chain.doFilter(req, resp);
	}

	/**
	 * アプリケーション終了時の処理実装
	 */
	@Override
	public void destroy() {
		super.destroy();
	}

}
