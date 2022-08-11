package aston.studentlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aston.studentlog.dao.LogDAO;
import aston.studentlog.model.Log;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDAO logDAO;
	
	@Override
	@Transactional
	public List<Log> getLogs() {
		return logDAO.getLogs();
	}

	@Override
	@Transactional
	public void saveLog(Log theLog) {
		theLog.setId(0);
		logDAO.saveLog(theLog);
	}

	@Override
	@Transactional
	public void deleteLog(int theId) {		
		logDAO.deleteLog(theId);
	}

	@Override
	@Transactional
	public List<Log> getStudentLogs(int id) {
		return logDAO.getStudentLogs(id);
	}

}
