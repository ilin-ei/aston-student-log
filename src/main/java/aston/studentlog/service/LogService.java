package aston.studentlog.service;

import java.util.List;

import aston.studentlog.model.Log;

public interface LogService {

	public List<Log> getLogs();

	public void saveLog(Log theLog);

	public void deleteLog(int theId);
	
	public List<Log> getStudentLogs(int studentId);
	
}
