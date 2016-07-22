package qdlg.zy.ccp.bean;

import java.io.Serializable;

/**
 * 用户建立的相册表
 * 
 * @author Administrator
 * 
 */
public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 相册id 主键 自增长
	 */
	private Long id;
	/**
	 * 相册名称
	 */
	private String name;
	/**
	 * 相册描述
	 */
	private String describe;
	/**
	 * 相册点赞数量
	 */
	private Integer likesNum;
	/**
	 * 相册评论数量
	 */
	private Integer commentNum;
	/**
	 * 相册创建地点
	 */
	private String location;
	/**
	 * 相册包含照片数
	 */
	private Integer photoNum;
	/**
	 * 相册创建人ID 外键
	 */
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(Integer photoNum) {
		this.photoNum = photoNum;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
