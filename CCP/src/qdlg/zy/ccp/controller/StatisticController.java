package qdlg.zy.ccp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import qdlg.zy.ccp.bean.Region;
import qdlg.zy.ccp.bean.Statistic;
import qdlg.zy.ccp.dao.RegionDAO;
import qdlg.zy.ccp.dao.StatisticDAO;

@Controller
@RequestMapping("/statistic")
public class StatisticController {
	@Resource
	private StatisticDAO statisticDAO;
	
	@RequestMapping("/getStatistic")
	@ResponseBody
	public List<Statistic> getStatistic() {
		return statisticDAO.getAll();
	}
}
