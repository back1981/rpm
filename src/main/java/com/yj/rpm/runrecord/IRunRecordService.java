package com.yj.rpm.runrecord;

import java.util.List;

public interface IRunRecordService {
	public void save(RunRecord rRecord);
	public List<RunRecord> findByRunId(String runId);
	public List<RunRecord> findByHostName(String hostName);
}
