package com.yj.rpm.mcr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.rpm.runrecord.IRunRecordService;
import com.yj.rpm.runrecord.RunRecord;

@Service
public class MethodCallRecordService implements IMethodCallRecordService {
	@Autowired
	private MethodCallRecordRepository methodCallRepo = null;
	@Autowired
	private IRunRecordService runRecordService = null;

//	@Override
//	public List<CostlyMethod> findCostlyDAOMethods(String runId) {
//		List<MethodCallRecord>  methodCallRecords = methodCallRepo.findByRunid(runId);		
//		return null;
//	}

	@Override
	public void saveMethodCallRecord(MethodCallRecord methodCallRecord) {
		List<RunRecord> rRecords = runRecordService.findByRunId(methodCallRecord.getRunId());
		if(rRecords.isEmpty()) {
			RunRecord rRecord = new RunRecord();
			rRecord.setAppName(methodCallRecord.getAppName());
			rRecord.setHostName(methodCallRecord.getHostName());
			rRecord.setRunId(methodCallRecord.getRunId());
			runRecordService.save(rRecord);
		}
		methodCallRepo.save(methodCallRecord);
	}


	@Override
	public List<MethodCallRecord> findByRunId(String runId) {
		return methodCallRepo.findByRunId(runId);
	}
}
