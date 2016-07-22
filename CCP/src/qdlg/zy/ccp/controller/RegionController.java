package qdlg.zy.ccp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import qdlg.zy.ccp.bean.Region;
import qdlg.zy.ccp.dao.RegionDAO;

@Controller
@RequestMapping("/region")
public class RegionController {
	@Resource
	private RegionDAO regionDAO;

	@RequestMapping("/province")
	public String provinceSelector(Model model) {
		
		model.addAttribute("province", regionDAO.queryByParentCode("0"));
		System.out.println("sss:"+regionDAO.queryByParentCode("0").size());
		return "/publicTool/city-selector";
	}
	@RequestMapping("/citySelector")
	@ResponseBody
	public List<Region> citySelector(Model model,@RequestParam("parentCode")String parentCode) {
		System.out.println("----"+parentCode);
		return regionDAO.queryByParentCode(parentCode);
	}
}
