package qdlg.zy.ccp.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户发表的动态表
 * 
 * @author Administrator
 * 
 */
public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 状态id 主键 自增
	 */
	private Long id;
	/**
	 * 状态内容
	 */
	private String content;
	/**
	 * 发表时间
	 */
	private Date time;
	/**
	 * 点赞数量
	 */
	private Integer likesNum;
	/**
	 * 评论数量
	 */
	private Integer commentNum;
	/**
	 * 发表状态的用户id
	 */
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getLikesNum() {
		return likesNum;
	}

	public void setLikesNum(Integer likesNum) {
		this.likesNum = likesNum;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
