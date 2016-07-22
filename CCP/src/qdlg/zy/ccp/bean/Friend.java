package qdlg.zy.ccp.bean;

import java.io.Serializable;

/**
 * 用户好友关系表
 * 
 * @author Administrator
 * 
 */
public class Friend implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 好友id
	 */
	private Long friendId;
	/**
	 * ' 所在列表id
	 */
	private Long friendListId;
	/**
	 * 用户id
	 */
	private Long userId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getFriendId() {
		return friendId;
	}

	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}

	public Long getFriendListId() {
		return friendListId;
	}

	public void setFriendListId(Long friendListId) {
		this.friendListId = friendListId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
