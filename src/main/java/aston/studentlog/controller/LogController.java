package aston.studentlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aston.studentlog.model.Log;
import aston.studentlog.service.LogService;

@RestController
@RequestMapping("/log-list")
public class LogController {

	@Autowired
	private LogService logService;
	
	@GetMapping("/logs")
	public List<Log> getLogs(){		
		return logService.getLogs();
	}
	
	@GetMapping("/logs/{id}")
	public List<Log> getStudentLogs(@PathVariable int id){
		return logService.getStudentLogs(id);
	}
	
	@PutMapping("/logs")
	public Log updateLog(@RequestBody Log theLog) {
	
		logService.saveLog(theLog);
		return theLog;
	}
	
	@PostMapping("/logs")
	public Log addLog(@RequestBody Log theLog) {
		
//		theLog.setId(0);
		logService.saveLog(theLog);				
		return theLog;
	}
	
	@DeleteMapping("/logs/{logId}")
	public String deleteLog(@PathVariable int logId){

		logService.deleteLog(logId);
		return "Deleted log " + logId;
	}
}
