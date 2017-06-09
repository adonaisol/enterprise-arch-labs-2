package cs544.sph2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String studentIdStr = request.getParameter("studentid");
		
		long studentid = -1;
		Student student = null;
//		Student newSt = new Student(11334, "Frank", "Brown");
//		Course course1 = new Course(1101, "Java", "A");
//		Course course2 = new Course(1102, "Math", "B-");
//		newSt.addCourse(course1);
//		newSt.addCourse(course2);
//		StudentService studentService = new StudentService();
//		studentService.add(newSt);
		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			ServletContext context=getServletContext();
			WebApplicationContext appContext=WebApplicationContextUtils.getWebApplicationContext(context);
			StudentService studentService=appContext.getBean("studentService",StudentService.class);
			
		
			studentid = Long.parseLong(studentIdStr);
		
			student = studentService.getStudent(studentid);
			
		}
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);		

	}

}
