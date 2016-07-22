package qdlg.zy.ccp.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户工作信息表
 * 
 * @author Administrator
 * 
 */
public class Job implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 工作id（主键） 数据库自增
	 */
	private Long id;
	/**
	 * 公司名称
	 */
	private String firmName;
	/**
	 * 行业
	 */
	private String industry;
	/**
	 * 职位
	 */
	private String position;
	/**
	 * 工作开始时间
	 */
	private Date startTime;
	/**
	 * 工作结束时间
	 */
	private Date endTime;
	/**
	 * 用户ID
	 */
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
