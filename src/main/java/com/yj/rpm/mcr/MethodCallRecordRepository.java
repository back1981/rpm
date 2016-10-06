package com.yj.rpm.mcr;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MethodCallRecordRepository extends MongoRepository<MethodCallRecord, ObjectId>{
//	public List<MethodCallRecord> findByAppNameAndHostName(String appName, String hostName, long from, long to);
	public List<MethodCallRecord> findByRunId(String runId);
}
