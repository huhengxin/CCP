package qdlg.zy.ccp.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import qdlg.zy.ccp.bean.TestBean;
import qdlg.zy.ccp.dao.RegionDAO;
import qdlg.zy.ccp.dao.TestDAO;
import qdlg.zy.ccp.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	private final static Logger logger = LoggerFactory
			.getLogger(TestController.class);

	@Resource
	private TestService testService;
	
	@RequestMapping("/test")
	public String test(Model model){
//		Demo demo = new Demo();
//    	demo.setName("aaa");
//    	demo = demoService.add(demo);
//    	System.out.println(demo.getId());
//    	model.addAttribute("demo", demo);
		return "/demo/user";
	}
	
	@RequestMapping("/register")
	public String register(){
		return "/test/register";
	}
	
	@RequestMapping("/add")
	public String add(Model model, TestBean demo){
		if(demo != null && demo.getName() != null && demo.getPassword() != null){
			testService.add(demo);
			model.addAttribute("demo", "aaa");
//			model.addAttribute("demo", demo);
		} else {
			model.addAttribute("demo", "bbb");
		}
		return "/test/register";
//		return "redirect:/demo/register"; //閲嶅畾鍚?
	}
	
	
	
}
