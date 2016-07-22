package qdlg.zy.ccp.bean;

import java.io.Serializable;

/**
 * 用户好友列表
 * 
 * @author Administrator
 * 
 */
public class FriendList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 列表id 主键 自增
	 */
	private Long id;
	/**
	 * 创建用户id
	 */
	private Long userId;
	/**
	 * 列表名称
	 */
	private String name;
	/**
	 * 包含好友个数
	 */
	private Integer friendNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFriendNum() {
		return friendNum;
	}

	public void setFriendNum(Integer friendNum) {
		this.friendNum = friendNum;
	}

}
