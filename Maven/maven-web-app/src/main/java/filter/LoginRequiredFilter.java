package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter(urlPatterns = "*.do")
public class LoginRequiredFilter implements Filter {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) ServletRequest;
		System.out.println(request.getRequestURI());
		
		if(request.getSession().getAttribute("name") != null) {
			chain.doFilter(ServletRequest, ServletResponse);
		} else {
			request.getRequestDispatcher("/login.do").forward(ServletRequest, ServletResponse);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
