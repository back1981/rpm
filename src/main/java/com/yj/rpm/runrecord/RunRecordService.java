package com.yj.rpm.runrecord;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunRecordService implements IRunRecordService {
	
	@Autowired
	private RunRecordRepository runRecordRepo = null;
	
	public List<RunRecord> findByRunId(String runId) {
		return runRecordRepo.findByRunId(runId);
	}
	
	public List<RunRecord> findByHostName(String hostName) {
		return runRecordRepo.findByHostName(hostName);
	}

	@Override
	public void save(RunRecord rRecord) {
		runRecordRepo.save(rRecord);
		
	}
}
