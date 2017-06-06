package cs544.hap2;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;
import java.util.Collection;

public class StudentDAO {

	//private Collection<Student> studentlist = new ArrayList<Student>();
	Session session = null;
	public StudentDAO() {
		/*Student student = new Student(11334, "Frank", "Brown");
		Course course1 = new Course(1101, "Java", "A");
		Course course2 = new Course(1102, "Math", "B-");
		student.addCourse(course1);
		student.addCourse(course2);
		//studentlist.add(student);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			session.merge(student);
			session.getTransaction().commit();
		}catch (Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}*/
	}

	public Student load(long studentid) {
		return (Student)HibernateUtil.getSessionFactory().getCurrentSession().get(Student.class, studentid);
		/*List<Student> studentList = session.createQuery("from Student").list();
		for (Student student : studentList) {
			if (student.getStudentid() == studentid) {
				return student;
			}
		}
		return null;*/
	}
}
