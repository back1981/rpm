package com.yj.rpm.aggr;

import com.yj.rpm.mcr.MethodCallRecord;

public class CostlyMethod {
	private String className;
	private String methodName;
	private int calledTimes;
	private int totalCostTimeInMills;
	private long max = Integer.MIN_VALUE;
	private long min = Integer.MAX_VALUE;
	
	public void cal(MethodCallRecord mcr) {
		calledTimes++;
		totalCostTimeInMills += mcr.getDuration();
		if(max < mcr.getDuration()) {
			max = mcr.getDuration();
		}
		if(min > mcr.getDuration()) {
			min = mcr.getDuration();
		}
	}
	public long getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public long getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public int getCalledTimes() {
		return calledTimes;
	}
	public void setCalledTimes(int calledTimes) {
		this.calledTimes = calledTimes;
	}
	public int getTotalCostTimeInMills() {
		return totalCostTimeInMills;
	}
	public void setTotalCostTimeInMills(int totalCostTimeInMills) {
		this.totalCostTimeInMills = totalCostTimeInMills;
	}
	
	
}
