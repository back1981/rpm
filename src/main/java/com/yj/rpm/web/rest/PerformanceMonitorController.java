package com.yj.rpm.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.rpm.aggr.CostlyMethod;
import com.yj.rpm.aggr.IAggrService;

@Controller
public class PerformanceMonitorController {
	@Autowired
	private IAggrService aggrService = null;
	
	@RequestMapping("/findCostlyMethods")
	@ResponseBody
	public List<CostlyMethod> findCostlyMethods(String runId, int n) {
		return aggrService.findCostlyMethod(runId, n);
	}
}
