package cs544.sph2;

import java.util.Collection;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class StudentService {
	@Autowired
	private StudentDAO studentDAO;
	
	//private SessionFactory sf=HibernateUtil.getSessionFactory();

	public StudentService() {
		//studentDAO = new StudentDAO();
	}
	public void add(Student student){
		//Transaction tx=sf.getCurrentSession().beginTransaction();
		
		studentDAO.create(student);
	//	tx.commit();
	}

	public Student getStudent(long studentid) {
		//Transaction tx=sf.getCurrentSession().beginTransaction();
		System.out.println("student id"+ studentid);
		System.out.println(studentDAO);
		Student st= studentDAO.load(studentid);
	//	Hibernate.initialize(st.getCourselist());
		//tx.commit();
		return st;
	}
	public Collection<Student> getAllStudents(){
		//return studentDAO.l
		return null;
	}
}
