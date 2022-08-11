package aston.studentlog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aston.studentlog.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Student> getStudents() {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		Query<Student> theQuery = currentSession.createQuery("from Student order by id", Student.class);
		
		List<Student> students = theQuery.getResultList();
				
		return students;
	}

	@Override
	public void saveStudent(Student theStudent) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theStudent);
	}

	@Override
	public Student getStudent(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Student theStudent = currentSession.get(Student.class, theId);
		
		return theStudent;
	}

	@Override
	public void deleteStudent(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query logQuery = currentSession.createQuery("delete from Log where student_id=:studentId");
		
		logQuery.setParameter("studentId", theId);
		
		logQuery.executeUpdate();
		
		Query studentQuery = currentSession.createQuery("delete from Student where id=:studentId");

		studentQuery.setParameter("studentId", theId);

		studentQuery.executeUpdate();
	}
}
