package com.yj.rpm.aggr;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.rpm.mcr.IMethodCallRecordService;
import com.yj.rpm.mcr.MethodCallRecord;

@Service
public class AggrService implements IAggrService{
	@Autowired
	private IMethodCallRecordService mcrService = null;
	
	public List<CostlyMethod> findCostlyMethod(String runId, int n) {
		return findCostlyMethod(mcrService.findByRunId(runId), n);
	}
	public List<CostlyMethod> findCostlyMethod(List<MethodCallRecord> records, int n) {
		// List<CostlyMethod> costlyMethods = new LinkedList<CostlyMethod>();
		Map<String, CostlyMethod> costlyMethods = new HashMap<String, CostlyMethod>();
		for (MethodCallRecord r : records) {
			String className = r.getClassName();
			String methodName = r.getMethodName();
			String key = className + ":" + methodName;
			CostlyMethod cm = costlyMethods.get(key);
			if (cm == null) {
				cm = new CostlyMethod();
				cm.setClassName(className);
				cm.setMethodName(methodName);
				cm.cal(r);
				costlyMethods.put(key, cm);
			}
		}
		return costlyMethods.values().stream().sorted(new CostlyMethodComparator()).limit(n).collect(toList());
	}

	public class CostlyMethodComparator implements Comparator<CostlyMethod> {

		@Override
		public int compare(CostlyMethod o1, CostlyMethod o2) {
			return Integer.compare(o1.getTotalCostTimeInMills(), o2.getTotalCostTimeInMills());
		}

	}

}
