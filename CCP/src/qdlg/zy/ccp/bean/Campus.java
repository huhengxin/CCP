package qdlg.zy.ccp.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户学校信息表
 * 
 * @author Administrator
 * 
 */
public class Campus implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 学校ID（主键）数据库自动生成
	 */
	private Long id;
	/**
	 * 学校类型（0-初中，1-高中，2-大学，3-研究生学校）
	 */
	private Integer type;
	/**
	 * 学校名字
	 */
	private String name;
	/**
	 * 入学年份
	 */
	private Date year;
	/**
	 * 院系
	 */
	private String department;
	/**
	 * 班级
	 */
	private String classes;
	/**
	 * 用户ID(外键)
	 */
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
