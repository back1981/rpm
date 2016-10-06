package com.yj.rpm.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yj.rpm.aggr.IAggrService;

@Controller
@RequestMapping("/detail")
public class DetailUIController {

	@Autowired
	IAggrService aggrService = null;

	@RequestMapping("/{runId}")
	public String findByHost(@PathVariable String runId,
			@RequestParam(value = "topN", required = false, defaultValue = "10") int n, Model model) {
		model.addAttribute("records", aggrService.findCostlyMethod(runId, n));
		return "detail";
	}
}
