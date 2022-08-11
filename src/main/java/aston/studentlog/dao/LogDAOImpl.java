package aston.studentlog.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import aston.studentlog.model.Log;

@Repository
public class LogDAOImpl implements LogDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Log> getLogs() {
		
		Session currentSession = sessionFactory.getCurrentSession();
				
		Query<Log> theQuery = currentSession.createQuery("from Log order by id", Log.class);
		
		List<Log> logs = theQuery.getResultList();
				
		return logs;
	}

	@Override
	public void saveLog(Log theLog) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theLog);
	}

	@Override
	public void deleteLog(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Log where id=:logId");
		theQuery.setParameter("logId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public List<Log> getStudentLogs(int studentId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Log> theQuery = currentSession.createQuery("from Log where student_id=:theId", Log.class);
		theQuery.setParameter("theId", studentId);
		
		List<Log> logs = theQuery.getResultList();
				
		return logs;
	}

}
