package com.yj.rpm.aggr;

import java.util.List;

public interface IAggrService {
	public List<CostlyMethod> findCostlyMethod(String runId, int n ) ;
}
