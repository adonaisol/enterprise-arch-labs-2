package cs544.hap2;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO implement actual session in view filter code

		Transaction tx = null;
		// pass the request along the filter chain
		try {
			tx = sessionFactory.getCurrentSession().beginTransaction();
			System.out.println("receiving request");
			chain.doFilter(request, response);
			tx.commit();
			System.out.println("sending response");

		}catch(Exception e){
			tx.rollback();
		}

	}

	public void destroy() {

	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
