package qdlg.zy.ccp.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;



/**
 * 用户基本信息表
 * 
 * @author Administrator
 * 
 */
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 用户ID（主键） 数据库自动生成
	 */
	private Long id;
	/**
	 * 登录密码
	 */
	private String passw;
	/**
	 * 头像链接
	 */
	private String avatar;
	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 性别,0-女，1-男
	 */
	private Integer gender;
	/**
	 * 出生日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String birth;
	/**
	 * 家乡
	 */
	private String hometown;
	/**
	 * 目前所在地
	 */
	private String location;
	/**
	 * 感情状态（0-单身，1-热恋，2-结婚，3-离异）
	 */
	private Integer feeling;
	/**
	 * 手机号（注册用）
	 */
	private String telephone;
	/**
	 * 邮箱（注册用）
	 */
	private String email;
	/**
	 * 用户状态（0-禁用、1-正常、2-删除）
	 */
	private Integer state;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginName;
	/**
	 * 最后登录IP
	 */
	private String lastLoginIP;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassw() {
		return passw;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getFeeling() {
		return feeling;
	}

	public void setFeeling(Integer feeling) {
		this.feeling = feeling;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getLastLoginName() {
		return lastLoginName;
	}

	public void setLastLoginName(Date lastLoginName) {
		this.lastLoginName = lastLoginName;
	}

	public String getLastLoginIP() {
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

}
