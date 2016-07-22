package qdlg.zy.ccp.dao;

import qdlg.zy.ccp.bean.User;

/**
 * 用户功能接口 
 * @author Administrator
 */
public interface UserDAO extends BaseDAO<User> {
	/**
	 * 用户注册查重 方法
	 * @param loginName 页面输入的登录名
	 * @return 是否存在该账号
	 */
	public User checkUser(String loginName);

	public void addBasicInfor(User user);

}
