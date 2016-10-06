package com.yj.rpm.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yj.rpm.runrecord.RunRecordService;

@Controller
@RequestMapping("/runRecord")
public class RunRecordUIController {
	@Autowired
	private RunRecordService rrService = null;

	@RequestMapping("/{host}")
	public String findByHost(@PathVariable String host, Model model) {
		model.addAttribute("records", rrService.findByHostName(host));
		return "RunRecord";
	}
}
