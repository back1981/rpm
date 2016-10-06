package com.yj.rpm.mcr;

import java.util.List;

public interface IMethodCallRecordService {
	public void saveMethodCallRecord(MethodCallRecord methodCallRecord);
	public List<MethodCallRecord> findByRunId(String runId);
	
}
