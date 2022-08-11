package aston.studentlog.dao;

import java.util.List;

import aston.studentlog.model.Log;

public interface LogDAO {

	public List<Log> getLogs();

	public void saveLog(Log theLog);

	public void deleteLog(int theId);
	
	public List<Log> getStudentLogs(int id);
	
}
