package qdlg.zy.ccp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import qdlg.zy.ccp.bean.TestBean;
import qdlg.zy.ccp.dao.TestDAO;
import qdlg.zy.ccp.service.TestService;



@Service("testService")
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestDAO testDAO;

	public TestBean add(TestBean demo) {
		testDAO.add(demo);
		return demo;
	}

	
}
