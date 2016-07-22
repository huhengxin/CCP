package qdlg.zy.ccp.bean;

import java.io.Serializable;

/**
 * 用户爱好表
 * 
 * @author Administrator
 * 
 */
public class Hobby implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 爱好id 主键 自增
	 */
	private Long id;
	/**
	 * 用户id 外键
	 */
	private Long userId;
	/**
	 * 爱好类型
	 * 1-音乐，2-书籍，3-电影，4-游戏，5-运动，6-动漫，7-其他
	 */
	private Integer type;
	/**
	 * 描述
	 */
	private String describe;

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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
