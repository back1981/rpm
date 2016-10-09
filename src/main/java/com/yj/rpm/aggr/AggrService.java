package com.yj.rpm.aggr;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yj.rpm.mcr.IMethodCallRecordService;
import com.yj.rpm.mcr.MethodCallRecord;

@Service
public class AggrService implements IAggrService{
	@Autowired
	private IMethodCallRecordService mcrService = null;
	
	public List<CostlyMethod> findCostlyMethod(String runId, int n) {
		return findCostlyMethod(mcrService.findByRunId(runId), n, null);
	}
	
	public List<CostlyMethod> findCostlyDaoMethod(String runId, int n) {
		return findCostlyMethod(mcrService.findByRunId(runId), n, m->m.getClassName().endsWith("DAO"));
	}
	
	public List<CostlyMethod> findCostlySoaMethod(String runId, int n) {
		return findCostlyMethod(mcrService.findByRunId(runId), n, m->m.getClassName().endsWith("Consumer"));
	}
	
	public List<CostlyMethod> findCostlyMethod(List<MethodCallRecord> records, int n, Predicate<CostlyMethod> filter) {
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
		if(filter != null) {
			return costlyMethods.values().stream().filter(filter).sorted(new CostlyMethodComparator()).limit(n).collect(toList());
		} else {
			return costlyMethods.values().stream().sorted(new CostlyMethodComparator()).limit(n).collect(toList());
		}
	}
	
	

	public class CostlyMethodComparator implements Comparator<CostlyMethod> {

		@Override
		public int compare(CostlyMethod o1, CostlyMethod o2) {
			return Integer.compare(o1.getTotalCostTimeInMills(), o2.getTotalCostTimeInMills());
		}

	}

}
