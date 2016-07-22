package qdlg.zy.ccp.bean;

import java.io.Serializable;

/**
 * 用户上传的照片表
 * 
 * @author Administrator
 * 
 */
public class Photo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 图片id 主键 自增长
	 */
	private Long id;
	/**
	 * 图片链接
	 */

	private String url;
	/**
	 * 点赞数量
	 */
	private Integer likesNum;
	/**
	 * 评论数量
	 */
	private Integer commentNum;
	/**
	 * 照片描述
	 */
	private String describe;
	/**
	 * 所属相册id
	 */
	private Long albumId;
	/**
	 * 上传图片的用户id
	 */
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
