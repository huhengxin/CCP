package qdlg.zy.ccp.dao;

import java.util.List;

import qdlg.zy.ccp.bean.Region;
/**
 * 用户功能接口
 * @author Administrator
 *
 */
public interface RegionDAO extends BaseDAO<Region>{

	/**
	 * 根据上级编码查询下级所有地区
	 * @param parentCode 上级编码
	 * @return 对应地区
	 */
	public List<Region> queryByParentCode(String parentCode);
	/**
	 * 根据地区编码查询上级省编码
	 * @param regionCode
	 * @return
	 */
	public String queryCodeByRegion(String regionCode);
}
