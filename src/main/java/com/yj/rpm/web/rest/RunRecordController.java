package com.yj.rpm.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.rpm.runrecord.RunRecord;
import com.yj.rpm.runrecord.RunRecordService;

@Controller
@RequestMapping("/api/runRecord")
public class RunRecordController {
	@Autowired
	private RunRecordService rrService = null;
	
	@RequestMapping("/{host}")
	@ResponseBody
	public List<RunRecord> findByHost(@PathVariable String host) {
		return rrService.findByHostName(host);
	}
}
