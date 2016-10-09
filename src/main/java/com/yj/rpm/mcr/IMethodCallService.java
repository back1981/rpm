package com.yj.rpm.mcr;

import java.util.List;

public interface IMethodCallService {
	public List<MethodCallRecord> findChild(MethodCallRecord r, List<MethodCallRecord> records);
}
