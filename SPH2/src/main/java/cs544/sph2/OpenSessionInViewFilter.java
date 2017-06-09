package cs544.sph2;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	//private SessionFactory sf=HibernateUtil.getSessionFactory();
	private SessionFactory sf;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code
		Transaction tx=null;
		try{
			System.out.println("receiving request");

			tx=sf.getCurrentSession().beginTransaction();
			
			chain.doFilter(request, response);
			
			tx.commit();
			System.out.println("sending response");
		}
		catch (RuntimeException e) {
			
			// TODO: handle exception
		}
		
		// pass the request along the filter chain
//		System.out.println("receiving request");
//	//	chain.doFilter(request, response);
//		System.out.println("sending response");
	}

	public void destroy() {
	}

	public void init(FilterConfig config) throws ServletException {
		ServletContext context=config.getServletContext();
		WebApplicationContext appContext=WebApplicationContextUtils.getWebApplicationContext(context);
		sf=appContext.getBean("sessionFactory",SessionFactory.class);
	}
}
