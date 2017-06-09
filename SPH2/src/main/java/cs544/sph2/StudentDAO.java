package cs544.sph2;

import java.util.ArrayList;
import java.util.Collection;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Transactional(propagation=Propagation.MANDATORY)
public class StudentDAO {

	private Collection<Student> studentlist = new ArrayList<Student>();
	
	//private SessionFactory sf=HibernateUtil.getSessionFactory();

	//@Autowired
	private SessionFactory sessionFactory;
	public StudentDAO() {
	

	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public void create(Student student){
		sessionFactory.getCurrentSession().persist(student);
	}

	public Student load(long studentid) {
//		for (Student student : studentlist) {
//			if (student.getStudentid() == studentid) {
//				return student;
//			}
//		}
//		return null;
		return (Student)sessionFactory.getCurrentSession().get(Student.class, studentid);
	}
}
