package qdlg.zy.ccp.dao;

import java.util.List;

import qdlg.zy.ccp.bean.Region;
import qdlg.zy.ccp.bean.Statistic;
/**
 * 省市注册人员统计接口
 * @author Administrator
 *
 */
public interface StatisticDAO extends BaseDAO<Statistic>{

	/**
	 * 获取所有省市注册人员统计信息
	 * @return
	 */
	public List<Statistic> getAll();
	/**
	 * 根据省市编码修改人员数量
	 * @param code
	 */
	public void updateNum(String code);
	/**
	 * 得到 网站注册的总人数
	 * @return 
	 */
	public Long getSum();
}
