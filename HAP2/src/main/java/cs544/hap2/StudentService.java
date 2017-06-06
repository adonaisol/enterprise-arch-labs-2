package cs544.hap2;

import org.hibernate.Hibernate;

public class StudentService {
	private StudentDAO studentdao;
	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {

//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		Student student = studentdao.load(studentid);
//		Hibernate.initialize(student.getCourselist());
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();

		return student;
	}
}
