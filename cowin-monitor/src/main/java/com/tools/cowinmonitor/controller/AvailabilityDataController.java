package com.tools.cowinmonitor.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tools.cowinmonitor.chart.ChartService;

@Controller
@RequestMapping("/availability")
public class AvailabilityDataController {
	
	@Autowired
	private ChartService chartService;
	
	
	public void findAvailableLocations() {
		
	}
	
	public void findAvailableDistricts() {
		
	}
	
	@GetMapping("/regions")
	public String findAvailableRegions(Model model) {
		
		
		Arrays.asList(1,2,3);
		String name = "test";
		model.addAttribute("name", name);		
		return "Hello";
		
	}
	
	@GetMapping("/slots")
	public ModelAndView loadHomePage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		//get center names
		
		mv.addObject("districts", Arrays.asList("Thrissur"));	
		mv.addObject("centers", chartService.getMainCenters());
		return mv;
		
	}
	
	
	@GetMapping("/visualize/{centerName}")
	public ModelAndView findPastDataToVisualize(@PathVariable(name = "centerName") String centerName) {
		ModelAndView mv = new ModelAndView();
		System.out.println(centerName);
		mv.setViewName("visualize");
		mv.addObject("chartData", chartService.getVisualizationData(centerName));
		mv.addObject("location", centerName);
		return mv;
	}

}
