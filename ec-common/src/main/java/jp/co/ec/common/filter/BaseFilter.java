package jp.co.ec.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author kou1210hei<br>
 * 基底フィルタークラス<br>
 *
 */
public abstract class BaseFilter implements Filter {

	protected FilterConfig filterConfig;

	/**
	 * 初期化処理を行う。<br>
	 * @param filterConfig
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		System.out.println("【Filter】" + this.getClass().getSimpleName() + " start");
	}

	/**
	 * 継承先で各処理を実装する<br>
	 * @param req
	 * @param resp
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public abstract void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException;

	/**
	 * アプリケーション終了時の処理実装
	 */
	@Override
	public void destroy() {
		this.filterConfig = null;
	}
}
