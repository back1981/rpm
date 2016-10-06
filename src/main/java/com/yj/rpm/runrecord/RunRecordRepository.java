package com.yj.rpm.runrecord;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunRecordRepository extends MongoRepository<RunRecord, ObjectId>{
	public List<RunRecord> findByRunId(String runId);
	public List<RunRecord> findByHostName(String hostName);
}
